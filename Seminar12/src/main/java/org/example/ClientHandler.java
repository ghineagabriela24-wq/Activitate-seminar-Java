package org.example;

import java.io.*;
import java.net.*;

public class ClientHandler extends Thread {
    private Socket socket;
    private String clientName;
    private ClientHandler otherClient;
    private BufferedReader in;
    private PrintWriter out;

    public ClientHandler(Socket socket, String clientName) {
        this.socket = socket;
        this.clientName = clientName;

        try {
            in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            out = new PrintWriter(
                    socket.getOutputStream(), true
            );

            out.println("Te-ai conectat ca " + clientName);
            out.println("Asteapta mesaje de la celalalt client.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setOtherClient(ClientHandler otherClient) {
        this.otherClient = otherClient;
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    @Override
    public void run() {
        try {
            String message;

            while ((message = in.readLine()) != null) {
                if (message.equalsIgnoreCase("exit")) {
                    sendMessage("Te-ai deconectat.");
                    otherClient.sendMessage(clientName + " s-a deconectat.");
                    break;
                }

                System.out.println(clientName + ": " + message);
                otherClient.sendMessage(clientName + ": " + message);
            }

            socket.close();

        } catch (IOException e) {
            System.out.println(clientName + " s-a deconectat.");
        }
    }
}