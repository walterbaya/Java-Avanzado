package clientemensajeria;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceptorDeMensajes implements Runnable {

    private int puerto;
    private FXMLDocumentController controller;
    
    ReceptorDeMensajes(int puerto, FXMLDocumentController controller) {
        this.puerto = puerto;
        this.controller = controller;
    }

    @Override
    public void run() {

        while (true) {
            try {

                ServerSocket servicio = new ServerSocket(getPuerto(), 3000);

                Socket socketCliente = servicio.accept();

                ManejadorDeMensajes manejador = new ManejadorDeMensajes(socketCliente,controller);
                Thread hiloManejador = new Thread(manejador);
                hiloManejador.start();

            } catch (IOException ex) {
            }

        }
    }

    /**
     * @return the puerto
     */
    public int getPuerto() {
        return puerto;
    }

    /**
     * @param puerto the puerto to set
     */
    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }


}
