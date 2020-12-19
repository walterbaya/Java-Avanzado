package clientemensajeria;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

//va a ser una clase servidor
public class ReceptorDeContactos implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                /*abrir un MulticastSocket en el puerto 4000*/
                byte[] informacion = new byte[150];
                MulticastSocket puertaEntrada = new MulticastSocket(4000);

                /*registrar el multicast socket en el grupo 235.1.1.1*/

                puertaEntrada.joinGroup(InetAddress.getByName("235.1.1.1"));
                DatagramPacket paqueteDatos = new DatagramPacket(informacion, informacion.length);

                //Guardo la informacion recibida en el paqueteDeDatos para poder procesarlos
                puertaEntrada.receive(paqueteDatos);

                //por cada conexión recibida pasarle packet a una instancia de la clase ManejadorDeContactos y
                //arrancarla.

                ManejadorDeContactos manejador = new ManejadorDeContactos(/*Instancia parametros*/);
                manejador.setPacket(paqueteDatos);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}