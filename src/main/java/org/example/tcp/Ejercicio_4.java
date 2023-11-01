package org.example.tcp;

import java.net.*;
import java.io.*;

public class Ejercicio_4 {
    public static void main(String[] args) {
        // Declaracion del socket
        Socket so_echo;
        // Declaracion del InputStream para el socket
        DataInputStream data_in_socket;
        // Declaracion del InputStream para la linea de comandos
        DataInputStream data_in_consola;
        String linea;
        //Declaracion del OutStream
        PrintStream data_out_socket;
        // Declaracion del nombre del host servidor daytime
        String host = "localhost";
        // String host = "10.10.11.2"; // al server del lab
        try {
            //crea el socket y se intenta conectar
            so_echo = new Socket(host, 7);

            // crea el DataStream con InputStream del socket
            data_in_socket = new DataInputStream(so_echo.getInputStream());
            // crea el PrintStream con el OutputStream del socket
            data_out_socket = new PrintStream(so_echo.getOutputStream());

            // crea el Stream de entrada
            data_in_consola = new DataInputStream(System.in);

            while (true) {
                //lee una liena desde la consola
                linea = data_in_consola.readLine();
                if (linea.equals(".")) break;
                // envia la linea el Strem del Socket
                data_out_socket.println(linea);
                // lee los datos del InputSteeam del socket y
                //los envia a la salida estandar
                System.out.println(data_in_socket.readLine());
            } //fin del while

            //cierra la conexion
            so_echo.close();
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