package org.example.tcp;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class Ejercicio_6 {
    public static void main(String[] args) {
        String host = args[0];
        int port = Integer.parseInt(args[1]);

        try {
            Socket socket = new Socket(host, port);

            InetAddress remoteAddress = socket.getInetAddress();
            int remotePort = socket.getPort();

            System.out.println("Conexión exitosa a " + remoteAddress + " en el puerto " + remotePort);

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            System.out.println("Mensaje: " + inputStream.readLine());

            socket.close();
        } catch (Exception e) {
            System.err.println("Error al conectar al host: " + e.getMessage());
        }
    }
}
