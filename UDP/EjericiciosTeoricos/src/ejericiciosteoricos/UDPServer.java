package ejericiciosteoricos;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UDPServer {

	public static void main(String[] args) throws InterruptedException {

		try {

			DatagramSocket socket = new DatagramSocket(4100, InetAddress.getByName("localhost"));

			DatagramPacket dato = new DatagramPacket(

					"hola".getBytes(), // El array de bytes

					"hola".getBytes().length, // Su longitud

					InetAddress.getByName("localhost"), // Destinatario

					4000); // Puerto del destinatario

			while (true) {

				try {

					socket.send(dato);

					Thread.currentThread().sleep(2000);

				} catch (IOException ex) {

					Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);

				}

			}

		} catch (SocketException ex) {

			Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);

		} catch (UnknownHostException ex) {

			Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);

		}

	}

}
