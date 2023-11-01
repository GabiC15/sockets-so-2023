package org.example.tcp;

import java.net.Socket;

public class Ejercicio_1 {
    public static void main(String[] args) {
        String host = "localhost";
        int minPort = 1;
        int maxPort = 1024;

        System.out.println("Buscando puertos para " + host);
        printOpenPort(host, minPort, maxPort);

        host = "192.168.0.54";
        System.out.println("Buscando puertos para " + host);
        printOpenPort(host, minPort, maxPort);
    }

    private static void printOpenPort(String host, int minPort, int maxPort) {
        for (int port = minPort; port <= maxPort; port++) {
            try {
                Socket socket = new Socket(host, port);
                System.out.println("Puerto " + port + " está abierto");
                socket.close();
            } catch (Exception e) {
//                System.out.println("Puerto " + port + " está cerrado");
            }
        }
    }
}
