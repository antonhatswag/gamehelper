package sockets;

import java.io.*;
import java.net.*;

public class ProcessingServerClient {

    public ProcessingServerClient(ServerSocket server) throws IOException {

        Socket client = server.accept();
        DataInputStream input = new DataInputStream(client.getInputStream());
        String inputFromClient = input.readUTF();
        System.out.println(inputFromClient);

        if(inputFromClient.equals("show list")){
            System.out.println("preparing to show list");
        }

        System.out.println("if this was a thread it would be over now");

        client.close();
    }
}
