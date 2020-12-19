package clientemensajeria;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class EnviarDeMensajes implements Runnable {

    private int puerto;
    private String host;
    private String mensaje;

    public EnviarDeMensajes(int puerto, String host, String mensaje) {
        this.puerto = puerto;
        this.host = host;
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        try {
            Socket cliente = new Socket(getHost(), getPuerto());
            
            DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
            mensaje = "Mi mensaje es" + mensaje + "  y mi Numero de Host es: " + host;
            for (int j = 0; j < getMensaje().length(); j++) {
                salida.writeChar(getMensaje().charAt(j));
            }
            cliente.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

  
}
