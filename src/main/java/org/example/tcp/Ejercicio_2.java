package org.example.tcp;

import java.net.InetAddress;
import java.net.Socket;

public class Ejercicio_2 {
    public static void main(String[] args) {
        String host = "google.com";
        int port = 80;

        try {
            Socket socket = new Socket(host, port);

            InetAddress remoteAddress = socket.getInetAddress();
            int remotePort = socket.getPort();

            System.out.println("Conexión exitosa a " + remoteAddress + " en el puerto " + remotePort);

            socket.close();
        } catch (Exception e) {
            System.err.println("Error al conectar al host: " + e.getMessage());
        }
    }
}
