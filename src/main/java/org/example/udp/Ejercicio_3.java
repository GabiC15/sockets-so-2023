package org.example.udp;//importar las clases requeridas

import java.net.InetAddress;
import java.net.DatagramSocket;


public class Ejercicio_3 {
    public static void main(String arg[]) {
        try {
            int port_local = 80;
            DatagramSocket ds = new DatagramSocket(port_local);
            ds.setReceiveBufferSize(800);
            ds.setSendBufferSize(800);
            ds.setSoTimeout(1000);
            ds.connect(InetAddress.getByName("127.0.0.0"), 81);
            //mostrar los datos del socket
            System.out.println("Dir Local: " + ds.getLocalAddress());
            System.out.println("Puerto Local: " + ds.getLocalPort());
            System.out.println("Dir Remota: " + ds.getInetAddress());
            System.out.println("Puerto Remoto: " + ds.getPort());
            System.out.println("Buffer de recepción: " + ds.getReceiveBufferSize() + " bytes");
            System.out.println("Buffer de envío: " + ds.getSendBufferSize() + " bytes");
            System.out.println("Tiempo de TimeOut: " + ds.getSoTimeout() + " milisegundos");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}