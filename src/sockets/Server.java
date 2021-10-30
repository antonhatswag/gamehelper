package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class Server {

    private ServerSocket server;


    public Server(int port) throws IOException {
        server = new ServerSocket(port);
        server.setSoTimeout(100000);



    }

    public void runServer(){
        while(true){


            try{
                System.out.println("Waiting for client at port " + server.getLocalPort());
                ProcessingServerClient process = new ProcessingServerClient(server);

            }catch (IOException e){
                System.out.println("Error");
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        Server s = new Server(1234);
        s.runServer();

    }
}

