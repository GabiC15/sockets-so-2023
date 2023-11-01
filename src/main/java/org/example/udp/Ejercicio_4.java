package org.example.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Ejercicio_4 {

    private static final int MAX_LON = 1000;

    public static void main(String[] args) {
        byte pkg_byte[] = null; //buffer para la asignacion de los datos
        try {
            DatagramSocket ds = new DatagramSocket(88);
            byte buffer[] = new byte[MAX_LON]; //buffer solo para el DatagramPacket
            DatagramPacket data_reciv = new DatagramPacket(buffer, MAX_LON);
            ds.receive(data_reciv); //lee los datos
            pkg_byte = new byte[data_reciv.getLength()]; //array de bytes para los datos
            pkg_byte = data_reciv.getData(); // asigna los bytes de datos

            System.out.println(new String(pkg_byte, StandardCharsets.UTF_8).trim());
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
