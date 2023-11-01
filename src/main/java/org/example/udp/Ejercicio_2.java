package org.example.udp;

public class Ejercicio_2 {
    public static void main(String[] args) {
        byte idMensaje = "8".getBytes()[0];

        byte nroSecuencia1 = "1".getBytes()[0];
        String msj1 = "Hola";
        MSSP protocolo1 = new MSSP(idMensaje, nroSecuencia1, msj1);

        byte nroSecuencia2 = "2".getBytes()[0];
        String msj2 = "desde";
        MSSP protocolo2 = new MSSP(idMensaje, nroSecuencia2, msj2);

        byte nroSecuencia3 = "3".getBytes()[0];
        String msj3 = "udp";
        MSSP protocolo3 = new MSSP(idMensaje, nroSecuencia3, msj3);

        System.out.println("Protocolo 1: ");
        System.out.println(protocolo1.getId_msn());
        System.out.println(protocolo1.getSec_msn());
        System.out.println(protocolo1.getMsn() + "\n");

        System.out.println("Protocolo 2: ");
        System.out.println(protocolo2.getId_msn());
        System.out.println(protocolo2.getSec_msn());
        System.out.println(protocolo2.getMsn() + "\n");

        System.out.println("Protocolo 3: ");
        System.out.println(protocolo3.getId_msn());
        System.out.println(protocolo3.getSec_msn());
        System.out.println(protocolo3.getMsn() + "\n");
    }
}
