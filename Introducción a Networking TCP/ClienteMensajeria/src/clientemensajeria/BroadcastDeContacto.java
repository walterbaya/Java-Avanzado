package clientemensajeria;

import java.io.IOException;
import java.net.*;

public class BroadcastDeContacto implements Runnable{
    private int cicloSegundos;

    @Override
    public void run() {
        while(true){
            try {
                byte[] informacion = new byte[0];
                DatagramSocket cliente = new DatagramSocket();
                DatagramPacket paquete = new DatagramPacket(informacion, informacion.length, InetAddress.getByName("235.1.1.1"), 4000);
                cliente.send(paquete);
                Thread.sleep(cicloSegundos*1000);
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }

        }
    }
}
