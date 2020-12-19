package LogicaDeNegocio;

import clientemensajeria.FXMLDocumentController;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManejadorDeMensajes implements Runnable {

    private Socket socketCliente;
    public FXMLDocumentController controller;

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
            if (controller.getMensaje() == null) {
                controller.setMensaje(mensaje + "\n");
            } else {
                controller.setMensaje(controller.getMensaje() + mensaje + "\n");
                System.out.println(controller.getMensaje());
            }

            socketCliente.close();

        } catch (IOException ex) {
            
        }
    }

    public Socket getSocket() {
        return socketCliente;
    }

    public void setSocket(Socket socketServicio) {
        this.socketCliente = socketServicio;
    }

}
