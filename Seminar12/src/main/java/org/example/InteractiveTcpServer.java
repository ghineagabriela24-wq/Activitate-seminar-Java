package org.example;

import java.io.*;
import java.net.*;

public class InteractiveTcpServer {
    public static void main(String[] args) {
        int port = 5001;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Serverul asculta pe portul " + port);
            System.out.println("Se asteapta primul client...");

            Socket client1Socket = serverSocket.accept();
            System.out.println("Client 1 conectat.");

            System.out.println("Se asteapta al doilea client...");
            Socket client2Socket = serverSocket.accept();
            System.out.println("Client 2 conectat.");

            ClientHandler client1 = new ClientHandler(client1Socket, "Client 1");
            ClientHandler client2 = new ClientHandler(client2Socket, "Client 2");

            client1.setOtherClient(client2);
            client2.setOtherClient(client1);

            client1.start();
            client2.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}