package cliente.servidor;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
        
    public static void main( String args[] ) {
    
        //Se crea un socket para servidor llamado s
    
        ServerSocket s = null;
        //se crea a parte un socket s1
        Socket s1;
        String cadena = "Tutorial de Java!";
        int longCad;
        OutputStream s1out;
        // Establece el servidor en el socket 4321 (espera 300 segundos)

        try {
            //El puerto va a ser 4321, acordarse que el puerto es 
            //el numero que se le da a un programa, un numero identificador de un programa.
            s = new ServerSocket(4321,300);
        } catch(IOException e) {
            System.out.println(e);
        }
    
        // Ejecuta un bucle infinito de listen/accept

        while(true) {
            try {
                // Espera para aceptar una conexión
                //en s1 voy a tener el socket aceptado
                s1 = s.accept();
                System.out.println("Se Acepto la conexion, estoy esperando un cliente.");
                // Obtiene un controlador de fichero de salida asociado con el socket
                //con este outputStream voy a poder escribirle al socket s1 del 
                s1out = s1.getOutputStream();
            
            // Enviamos nuestro texto
            longCad = cadena.length();
            
            for( int i=0; i < longCad; i++ ){
                s1out.write((int)cadena.charAt( i ));
            }
                // Cierra la conexión, pero no el socket del servidor
                s1.close();
            } catch( IOException e ) {
                System.out.println( e );
            }
        }
    }
}
