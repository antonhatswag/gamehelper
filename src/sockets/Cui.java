package sockets;

import java.io.IOException;
import java.util.Scanner;

public class Cui {

    Client client;

    public Cui(Client client) {

         this.client = client;
    }

    public void mainMenu() throws IOException {
        System.out.println("1: show list");
        System.out.println("2: dont show list");

        Scanner in = new Scanner(System.in);

        int i = in.nextInt();

        if (i == 1){
            client.serverQuery("show list");
        }
        if (i == 2) {
            //nix
        }
    }
}
