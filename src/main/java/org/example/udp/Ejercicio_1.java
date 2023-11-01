package org.example.udp;//importar las clases requeridas

import java.net.InetAddress;
import java.net.DatagramPacket;

public class Ejercicio_1 {
    public static void main(String arg[]) {
        try {
            DatagramPacket paqueteUDP; //declaracion del paquete UDP
            String host = new String("127.0.0.1"); // Dir. Internet host remoto
            InetAddress dir_remota = InetAddress.getByName(host);
            int port = 1000; //puerto donde se envia el datagrama
            //Datos a enviar en el datagrama
            String datos = new String("Hola, estos son los datos !!");
            byte[] buffer = datos.getBytes(); // retorna los bytes del string
            //crear el paquete UDP
            paqueteUDP = new DatagramPacket(buffer, buffer.length, dir_remota, port);
            //mostrar los datos del paquete
            System.out.println("Paquete UDP :");
            System.out.println("Direccion Internet:" + paqueteUDP.getAddress());
            System.out.println("Datos :" + paqueteUDP.getData());
            System.out.println("Longitud :" + paqueteUDP.getLength());
            System.out.println("Offset :" + paqueteUDP.getOffset());
            System.out.println("Puerto :" + paqueteUDP.getPort());
        } //cierra el try
        catch (Exception e) {
            System.out.println(e);
        }
    } //cierra el main
}