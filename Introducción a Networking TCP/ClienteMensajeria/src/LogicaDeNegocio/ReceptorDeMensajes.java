package LogicaDeNegocio;

import clientemensajeria.FXMLDocumentController;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReceptorDeMensajes implements Runnable {

    private int puerto;
    private FXMLDocumentController controller;

    public ReceptorDeMensajes(int puerto, FXMLDocumentController controller) {
        this.puerto = puerto;
        this.controller = controller;
    }

    @Override
    public void run() {
        try {
            ServerSocket servicio = new ServerSocket(puerto);
            while (true) {

                Socket socketCliente = servicio.accept();

                ManejadorDeMensajes manejador = new ManejadorDeMensajes(socketCliente, controller);
                Thread hiloManejador = new Thread(manejador);
                hiloManejador.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(ReceptorDeMensajes.class.getName()).log(Level.SEVERE, null, ex);
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
