/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import java.io.IOException;
import java.util.Scanner;

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
        Scanner s = new Scanner(System.in);
        String dns = s.next();
            Server server = new Server(dns);
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
