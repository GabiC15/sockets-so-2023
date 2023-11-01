package org.example.udp;

import java.util.Arrays;

/**
 * Clase MSSP
 * Protocolo Simple de mensajes Cortos
 */
public class MSSP {
    // atributos de la clase
    byte id_msn;
    byte sec_msn;

    String msn;

    /**
     * Constructor de la clase
     * id_mensaje : identificador del mensaje
     * secuencia : numero de secuencia del mensaje
     * menasje : mensaje a enviar
     */
    MSSP(byte id_mensaje, byte secuencia, String mensaje) {
        id_msn = id_mensaje;
        sec_msn = secuencia;
        msn = mensaje;
    }

    /**
     * Constructor para armar un MSSP a partir de un array de bytes
     */
    MSSP(byte[] datos_UDP) {
        byte[] msg_aux; // variable auxiliar para armar el mensaje en un String
        id_msn = datos_UDP[0]; // copia el identificador
        sec_msn = datos_UDP[1]; // copia el numero de secuencia
        //dimensiona el array de byte para el mensaje String
        msg_aux = new byte[datos_UDP.length - 2];
        //copia los bytes del string
        for (int i = 2; i < datos_UDP.length; i++) msg_aux[i - 2] = datos_UDP[i];
        //transform el array de byte en un mansaje String
        msn = new String(msg_aux).trim();
    }

    byte[] toBytes() {
        byte[] messageBytes = new byte[3 + this.getMsn().length()];
        messageBytes[0] = this.getId_msn();
        messageBytes[1] = this.getSec_msn();
        byte[] messageData = this.getMsn().getBytes();
        System.arraycopy(messageData, 0, messageBytes, 2, messageData.length);

        return messageBytes;
    }

    public byte getId_msn() {
        return id_msn;
    }

    public void setId_msn(byte id_msn) {
        this.id_msn = id_msn;
    }

    public byte getSec_msn() {
        return sec_msn;
    }

    public void setSec_msn(byte sec_msn) {
        this.sec_msn = sec_msn;
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }
}
/**
 * retorna el MSSP como un array de bytes, listo para generar
 * un paquete UDP
 */