package org.example.tcp;

import java.net.*;
import java.io.*;

public class Puertos_tcp {
    public static void main(String[] args) {

        Socket so_check_port;
        String host = "www.google.com.ar";

        try {
            so_check_port = new Socket(host, 80);
            System.out.println("conectado:" + so_check_port.getInetAddress());
            System.out.println("port :" + so_check_port.getPort());
        } // try
        catch (UnknownHostException e) {
            System.out.println(e);
        } // catch
        catch (IOException e) {
            System.out.println(e);
        } // catch
    }
}
