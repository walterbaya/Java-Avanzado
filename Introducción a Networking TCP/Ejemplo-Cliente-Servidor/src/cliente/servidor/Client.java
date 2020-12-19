package cliente.servidor;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;


public class Client {

    public static void main( String args[] ) throws IOException {
        int c;
        Socket s = null;
        InputStream sIn;
        // Abrimos una conexión con breogan en el puerto 4321
        try {   
            InetAddress direccionDeLaMaquina = InetAddress.getLocalHost();
            s = new Socket(direccionDeLaMaquina,4321);
        }
        catch(IOException e) {
            System.out.println(e);
        }
        
        // Obtenemos un controlador de fichero de entrada del socket y leemos esa entrada
        System.out.println("se obtiene un inputStream para leer lo que mando el servidor: " + s.getInputStream());
        sIn = s.getInputStream();
        while(( c = sIn.read()) != -1){
            System.out.print((char)c);
        }
            // Cuando se alcance el fin de fichero, cerramos la conexión y abandonamos
            s.close();
    } 
}
