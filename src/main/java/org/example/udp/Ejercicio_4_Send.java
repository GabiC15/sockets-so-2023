package org.example.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Ejercicio_4_Send {

    public static void main(String[] args) {
        try { // necesario para capturar los posibles errores
            DatagramPacket paqueteUDP; //declaracion del paquete UDP
            InetAddress dir_remota = InetAddress.getByName( "localhost" );
            int port = 88;
            String datos = "Estos son los datos del datagrama";
            byte[] buffer = datos.getBytes(); // retorna los bytes del string
            paqueteUDP = new DatagramPacket(buffer, buffer.length, dir_remota, port);
            //crea el socket y envía el paquete
            DatagramSocket ds = new DatagramSocket();
            ds.send(paqueteUDP);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}
