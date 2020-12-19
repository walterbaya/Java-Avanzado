package clientemensajeria;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManejadorDeMensajes implements Runnable {

    private Socket socketCliente;
    private FXMLDocumentController controller;

    public ManejadorDeMensajes(Socket socketCliente, FXMLDocumentController controller) {
        this.socketCliente = socketCliente;
        this.controller = controller;
    }

    @Override
    public void run() {

        try {
            String mensaje = "";
            while (socketCliente.getInputStream().read() != -1) {
                mensaje = mensaje + ((char) (socketCliente.getInputStream().read()));
            }
            controller.setMensajesEntrantes(mensaje);
            System.out.println(mensaje);
        } catch (IOException ex) {
            Logger.getLogger(ManejadorDeMensajes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the socket
     */
    public Socket getSocket() {
        return socketCliente;
    }

    public void setSocket(Socket socketServicio) {
        this.socketCliente = socketServicio;
    }
}
