package ejericiciosteoricos;

import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MulticastServer1 {

    public static void main(String[] args) throws IOException {

        try {

            byte[] b = new byte[100];

            DatagramPacket dgram = new DatagramPacket(b, b.length);

            MulticastSocket socket = new MulticastSocket(4000); // must bind receive side

            socket.joinGroup(InetAddress.getByName("235.1.1.1"));

            while(true) {

                socket.receive(dgram); // blocks until a datagram is received

                System.err.println("Recibido  " + dgram.getLength() +

                        " bytes from " + dgram.getAddress() + new String(dgram.getData()) + "servidor1");

                dgram.setLength(b.length); // must reset length field!

            }

        } catch (SocketException ex) {

            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);

        }  catch (UnknownHostException ex) {

            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}