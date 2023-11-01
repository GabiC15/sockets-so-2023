package org.example.tcp;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Ejercicio_7_Client {
    public static void main(String[] args) {
        String host = args[0];
        int port = Integer.parseInt(args[1]);

        try {
            Socket socket = new Socket(host, port);

            InetAddress remoteAddress = socket.getInetAddress();
            int remotePort = socket.getPort();

            System.out.println("Conexión exitosa a " + remoteAddress + " en el puerto " + remotePort);

            boolean exit = false;
            while(!exit) {
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                System.out.println(inputStream.readLine());

                Scanner scanner = new Scanner(System.in);
                System.out.println("Ingrese un mensaje: ");

                String inputText = scanner.nextLine();
                PrintStream data_out_conex = new PrintStream(socket.getOutputStream());
                data_out_conex.println(inputText);

                if(inputText.equals("exit")) {
                    exit = true;
                }
            }

            socket.close();
        } catch (Exception e) {
            System.err.println("Error al conectar al host: " + e.getMessage());
        }
    }
}
