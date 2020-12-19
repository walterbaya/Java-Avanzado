package ejericiciosteoricos;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EjericiciosTeoricos {

	public static void main(String[] args) {
		try {

			// recibe un host por parametro,
			// el host puede ser el nombre de una maquina o la representacion en String de
			// la ip
			// caso con el nombre de una maquina en este caso localhost.

			InetAddress direccion = InetAddress.getByName("localhost");
			System.out.println(direccion);

			InetAddress direccion2 = InetAddress.getByName("www.google.com");

			System.out.println("Esta es la IP de Google: " + direccion2);

			System.out.println(direccion);

			// caso en el que directamente pasamos la direccion ip
			// y obtengo la direccion que el provedor de internet le signo a la direccion
			// sobre la cual se corre el programa que se ejecuto

			// Conseguir el nombre del host de Goolge a partir de la direccion ip

			int temp = direccion2.toString().indexOf('/');
			direccion2 = InetAddress.getByName(direccion2.toString().substring(temp + 1));
			System.out.println(direccion2);

			// Obtener la direccion de mi ordenador.

			InetAddress miHost = InetAddress.getLocalHost();
			System.out.println(miHost);

			// El servidor de nombres de dominio reconoce a la direccion numerica ip
			// proporcionada por el metodo getLocalHost con el nombre de localhost, lo cual
			// se puede ver asi

			int valorIp = miHost.toString().indexOf('/');
			miHost = InetAddress.getByName(miHost.toString().substring(valorIp + 1));
			System.out.println("El nombre de mi localhost es: " + miHost.getHostName());

			
			//obtengo el objeto inetAdress como una cadena de bytes, la cual almacena
			//informacion si se ve con claridad no son solo numeros tambien hay simbolos
			//al interpretarse esos simbolos como byte o como enteros voy a tener la Ip numerica.
			byte[] bytes = miHost.getAddress();
			
			//El getAddress devuelve una cadena de bytes que representa la IP.
			//El método getAddress() devuelve un objeto de tipo InetAddress que contiene la dirección del host remoto.
			
			System.out.println(miHost.getAddress());
			// Convierte los bytes de la dirección IP a valores sin
			// signo y los presenta separados por espacios
			for (int i = 0; i < bytes.length; i++) {
				int uByte = bytes[i] < 0 ? bytes[i] + 256 : bytes[i];
				System.out.print(uByte + " ");
			}
			
			
			///////////////////////////////////////////////////////////////////////////////////////
			//TRABAJANDO CON DATAGRAM SOCKETS
			
			//Para envío
/*
			DatagramPacket dato = new DatagramPacket(data, El array de bytes, Su longitud, Destinatario, Puerto del destinatario);


			//Para recepción

			DatagramPacket dato = new DatagramPacket(El array de bytes, Su longitud);


			65,535 bytes es el tamaño maximo que puede tener un datagrama, es bastante "poco" pero para las cosas que se hacen quizas sea mas que suficiente

			El método getData() devuelve un array de bytes que contiene la parte de datos del datagrama, ya eliminada la cabecera con la información de
			encaminamiento 	de ese datagrama


			//para envio

			DatagramSocket socket = new DatagramSocket(PUERTO_RECEPCION, InetAddress.getByName("localhost"));


		//para recepcion

		   DatagramSocket socket = new DatagramSocket(PUERTO_DESTINO, InetAddress.getByName(HOST_DESTINO));

		----------------------------------------------------MULTICAST----------------------------------------
	 	El multicast se da cuando tenemos un emisor, emisores que estan conectados a un grupo de
	 	multicast y al enviar un mensaje ese mensaje se envia a todos los que
	 	estan en ese grupo al mismo tiempo, las direcciones de host que se pueden usar para un
	 	multicas van de 224.0.0.0 a la 239.255.255.255

	 	Para enviar un mensaje no hace falta pertenecer al grupo de multicasting, pero si es necesario estar
	 	para recibir los mensajes.

	 	-------------------------------------------

El Multicast es un método de direccionamiento IP. Una dirección multicast está asociada con un grupo de
receptores interesados. De acuerdo al RFC 3171 las direcciones desde la 224.0.0.0 a la 239.255.255.255
están destinadas para ser direcciones de multicast. Este rango se llama formalmente "Clase D".

El emisor envía un único datagrama (desde la dirección unicast del emisor) a la dirección multicast
y el router se encargará de hacer copias y enviarlas a todos los receptores que hayan informado de su
interés por los datos de ese emisor.

La clase MulticastSocket proporciona dos constructores alternativos:

    MulticastSocket(): que crea el socket en cualquiera de los puertos locales libres.
    MulticastSocket(int port): que crea el socket en el puerto local indicado.

Un proceso puede pertenecer a un grupo multicast invocando el método joinGroup(InetAddress mcastaddr)
de su socket multicast. Así, el socket pertenecerá a un grupo de multidifusión en un puerto dado y
recibirá los datagramas enviados por los procesos en otros computadores a ese grupo en ese puerto.
Un proceso puede dejar un grupo dado invocando el método leaveGroup(InetAddress mcastaddr)  de su socket multicast.

Para enviar datos a un grupo multicast se utiliza el método send(DatagramPacket p), este método es muy similar al de la clase DatagramSocket,
la diferencia es que este datagrama será enviado a todos los miembros del grupo multicast.

Para recibir datos de un grupo multicast se utiliza el método receive(DatagramPacket p)
de la clase DatagramSocket super clase de MulticastSocket.

Es necesario pertenecer a un grupo para recibir mensajes multicast enviados a ese grupo,
pero no es necesario para enviar mensajes.
La clase Servidor Multicast UDP


MUCHOS SERVERS UN SOLO EMISOR... O VARIOS TAMBIEN.


*/





		} catch (UnknownHostException ex) {
			Logger.getLogger(EjericiciosTeoricos.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
