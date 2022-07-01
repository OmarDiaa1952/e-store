/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import java.io.IOException;

/**
 *
 * @author DEYOKHHA
 */
public class SuperMarketServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Database.create();
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

    }
    
}
