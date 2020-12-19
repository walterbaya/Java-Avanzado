package clientemensajeria;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ManejadorDeContactos implements Runnable{
    private DatagramSocket paquete;
    @Override
    public void run() {
        /*    obtener el InetAddress del packet
              agregar, si corresponde, el nuevo contacto
              en la lista de contactos*/

    }

    public void setPacket(DatagramPacket paqueteDatos) {
    }
}
 /*Agregarle la posibilidad de descubrir otros clientes
 de chat abiertos, así como también la posibilidad de ser
 descubierto:
 Cuando un cliente es levantado comienza a informar en forma
 continua y cada X cantidad de tiempo que se encuentra en ese
 estado. Esto se debe realizar enviando un mensaje por UDP al
 puerto 4000 y un datagrama a una IP de multicast
 (por ej 235.1.1.1)
 En forma paralela registrarse a la misma IP de multicast y al
 puerto 4000 para escuchar todos los posibles datagramas que
 lleguen. Así será posible detectar a todos los clientes de
 mensajería levantados y tomar sus host.
    Por cada datagrama detectado agregar un nuevo contacto en
    la lista, validando que ya no exista
    Opcionalmente, agregar la funcionalidad para detectar
    clientes desconectados y sacarlos de la lista*/