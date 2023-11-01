package org.example.tcp;

import java.net.*;
import java.io.*;


public class Ejercicio_3 {

    public static void main(String[] args) {

        Socket so_daytime; // declaracion del socket
        DataInputStream data_daytime; // declaracion del DataInputStream
        String host = "localhost";
        //String host = "10.10.11.2"; // al server del lab

        try {
            //crea el socket y se intenta conectar
            so_daytime = new Socket(host, 13);
            // crea el DataStream con InputStream del socket
            data_daytime = new DataInputStream(so_daytime.getInputStream());

            //lee una linea en el Stream,

            //en el stream estan los datos enviados por el server
            String line = data_daytime.readLine();

            // verifica el nombre del host y el puerto donde se conecto
            System.out.println("conectado a :" + so_daytime.getInetAddress());
            System.out.println("port :" + so_daytime.getPort());
            System.out.println("dia y hora :" + line);
            so_daytime.close();
        } // end try

        catch (UnknownHostException e) {
            // si hubo error lo envia a la salida por defecto
            System.out.println(e);
        } // end catch
        catch (IOException e) {
            // si hubo error lo envia a la salida por defecto
            System.out.println(e);
        }
    }
}
