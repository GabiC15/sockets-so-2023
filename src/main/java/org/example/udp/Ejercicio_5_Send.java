package org.example.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Ejercicio_5_Send {
    private static final int MAX_LON = 1000;

    public static void main(String[] args) {
        try {
            InetAddress dir_remota = InetAddress.getByName( "localhost" );
            int port = 80;

            byte id = 1;
            byte sequence = 1;
            String message = "Hola desde el Send";
            MSSP mssp = new MSSP(id, sequence, message);
            byte[] buffer = mssp.toBytes();

            DatagramPacket paqueteUDP = new DatagramPacket(buffer, buffer.length, dir_remota, port);

            DatagramSocket ds = new DatagramSocket();
            ds.send(paqueteUDP);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}
