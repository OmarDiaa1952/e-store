import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("Server or client :\n0) Server\n1) Client");
        int type = s.nextInt();
        if(type == 0){
            int port = 10000;
            Server server = new Server();
            while (true){
                try{
                    server.start(port);
                    break;
                }catch (IOException e){
                    port++;
                }
            }
        }else{
            Client client = new Client();
            client.startConnection();
        }
    }
}
