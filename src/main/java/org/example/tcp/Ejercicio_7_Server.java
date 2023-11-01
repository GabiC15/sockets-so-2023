package org.example.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Ejercicio_7_Server {

    public static void main(String[] args) {
        String host = args[0];
        int port = Integer.parseInt(args[1]);

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

                    data_out_conex = new PrintStream(so_conex.getOutputStream());

                    boolean exit = false;
                    while (!exit) {
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Ingrese un mensaje: ");

                        String inputText = scanner.nextLine();
                        data_out_conex.println(inputText);

                        DataInputStream inputStream = new DataInputStream(so_conex.getInputStream());
                        System.out.println(inputStream.readLine());

                        if(inputText.equals("exit")) {
                            exit = true;
                        }
                    }
                    so_conex.close();
                } //fin del while
            } // end try
            // end catch
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
