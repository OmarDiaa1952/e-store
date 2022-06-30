import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    private Socket clientSocket;
    private DataOutputStream out;
    private DataInputStream in;

    private final static String DNS = "http://192.168.1.18/dns.php?s=get";

    private String getServerIP() throws IOException {
        URL obj = new URL(DNS);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        if(responseCode == 200){
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            if("null".equalsIgnoreCase(response.toString())) {
                return null;
            }else{
                System.out.println("Found server @ " + response.toString());
                return response.toString();
            }
        }else return null;
    }
    public void startConnection() throws IOException {
        String serverIP = getServerIP();
        if(serverIP == null) {
            System.out.println("No servers found");
        }else{
            this.connect(serverIP);
            //Will add real commands
            Scanner s = new Scanner(System.in);
            while (true){
                String msg = s.next();
                String res = this.sendMessage(msg);
                if("err".equalsIgnoreCase(res)){
                    System.out.println("Server is down");
                    serverIP = getServerIP();
                    this.stopConnection();
                    if(serverIP == null) break;
                    else {
                        this.connect(serverIP);
                        res = this.sendMessage(msg);
                    }
                }
                System.out.println("Server responded : " + res);
                if("die".equalsIgnoreCase(res)) {
                    this.stopConnection();
                    break;
                };
            }
        }
    }
    public void connect(String serverIP) throws IOException {
        String ip = serverIP.split(":")[0];
        int port = Integer.parseInt(serverIP.split(":")[1]);
        clientSocket = new Socket(ip, port);
        System.out.println("Connected to " + ip + ":" + port);
        out = new DataOutputStream(clientSocket.getOutputStream());
        in = new DataInputStream(clientSocket.getInputStream());
    }

    public String sendMessage(String msg) throws IOException {
        String res;
        try {
            out.writeUTF(msg);
            res = in.readUTF();
        }catch (IOException e){
            res = "err";
        }
        return res;
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }
}
