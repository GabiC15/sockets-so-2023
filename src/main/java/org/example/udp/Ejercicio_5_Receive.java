package org.example.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;

public class Ejercicio_5_Receive {
    private static final int MAX_LON = 1000;

    public static void main(String[] args) {
        byte[] pkg_byte = null;
        try {
            DatagramSocket ds = new DatagramSocket(80);
            byte buffer[] = new byte[MAX_LON];
            DatagramPacket data_reciv = new DatagramPacket(buffer, MAX_LON);
            ds.receive(data_reciv);
            pkg_byte = new byte[data_reciv.getLength()];
            pkg_byte = data_reciv.getData();

            MSSP mssp = new MSSP(pkg_byte);

            System.out.println("Mensaje MSSP: ");
            System.out.println(mssp.getId_msn());
            System.out.println(mssp.getSec_msn());
            System.out.println(mssp.getMsn() + "\n");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
