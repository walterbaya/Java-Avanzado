package ejericiciosteoricos;

import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MulticastCliente {

    public static void main(String[] args) throws InterruptedException, IOException {

        try {

            DatagramSocket socket = new DatagramSocket();

            byte[] b = "Dario Hruszecki".getBytes();

            DatagramPacket dgram;
            //El getByName te devuelve una InetAddress con el numero de ip y el nombre de host
            //Aca el destinatario es la direccion 235.....
            dgram = new DatagramPacket(b, b.length, InetAddress.getByName("235.1.1.1"), 4000);

            System.err.println("Sending " + b.length + " bytes to " +

                    dgram.getAddress() + ':' + dgram.getPort());

            while(true) {
                //Se envia muchas veces el datagrama a la direccion 235.....
                System.err.print(".");

                socket.send(dgram);

                Thread.sleep(1000);

            }

        } catch (SocketException ex) {

            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);

        }  catch (UnknownHostException ex) {

            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

}
