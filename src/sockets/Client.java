package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public Cui cui;

    public Client() throws IOException {
        cui = new Cui(this);



    }

    public void serverQuery(String query) throws IOException {

        Socket client = new Socket("localhost", 1234);
        DataOutputStream output = new DataOutputStream(client.getOutputStream());
        output.writeUTF(query);

        client.close();



    }

    public static void main(String[] args) throws IOException {

        Client client = new Client();

        client.cui.mainMenu();

    }


}
