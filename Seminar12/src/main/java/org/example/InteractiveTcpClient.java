package org.example;

import java.io.*;
import java.net.*;

public class InteractiveTcpClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 5001;

        try {
            Socket socket = new Socket(host, port);

            BufferedReader serverIn = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            PrintWriter serverOut = new PrintWriter(
                    socket.getOutputStream(), true
            );

            BufferedReader userInput = new BufferedReader(
                    new InputStreamReader(System.in)
            );

            Thread readThread = new Thread(() -> {
                try {
                    String messageFromServer;

                    while ((messageFromServer = serverIn.readLine()) != null) {
                        System.out.println(messageFromServer);
                    }

                } catch (IOException e) {
                    System.out.println("Conexiunea cu serverul s-a inchis.");
                }
            });

            readThread.start();

            String userMessage;

            while (true) {
                userMessage = userInput.readLine();

                serverOut.println(userMessage);

                if (userMessage.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}