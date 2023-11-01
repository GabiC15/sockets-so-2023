package org.example.tcp;

import java.net.*;
import java.io.*;

public class Ejercicio_5 {

    public static void main(String[] args) {

        int port = 7000;
        if(args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
        // Declaracion del socket Servidor
        ServerSocket so_serv;

        //Declaracion del OutStream donde escribira el Socket de la conexion
        PrintStream data_out_conex;

        try { // try 1
            //crea el socket Server atendiendo en el puerto 7000
            so_serv = new ServerSocket(port);
            System.out.println("Servidor atendiendo en el puerto " + port);
            try {
                while (true) {

                    // Declara un socket para atender la conexion
                    Socket so_conex = so_serv.accept();

                    // crea el PrintStream con el OutputStream del socket
                    data_out_conex = new PrintStream(so_conex.getOutputStream());
                    data_out_conex.println("Se a conectado al socket servidor ");
                    so_conex.close();
                } //fin del while
            } // end try
            catch (UnknownHostException e) {
                // si hubo error lo envia a la salida por defecto
                System.out.println(e);
            } // end catch
            catch (IOException e) {
                // si hubo error lo envia a la salida por defecto
                System.out.println(e);
            }
            //cierra el socket Server
            so_serv.close();
        } // Cierra try 1
        catch (IOException e) {
            // si hubo error lo envia a la salida por defecto
            System.out.println(e);
        }
    }
}