package LogicaDeNegocio;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import clientemensajeria.FXMLDocumentController;

public class EnviarDeMensajes implements Runnable {

	private int puerto;
	private String host;
	private String mensaje;
	private FXMLDocumentController controller;

	public EnviarDeMensajes(int puerto, String host, String mensaje, FXMLDocumentController controller) {
		this.puerto = puerto;
		this.host = host;
		this.mensaje = mensaje;
		this.controller = controller;
	}

	@Override
	public void run() {

		try (Socket cliente = new Socket(host, puerto)) {
			DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
			mensaje = "Mi mensaje es: " + mensaje + "  y mi Numero de Host es: " + host;

			for (int j = 0; j < mensaje.length(); j++) {
				salida.writeChar(mensaje.charAt(j));
			}

			cliente.close();
		} catch (IOException ex) {
			controller.setMensaje("Error, la conexion está caída");
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

	public FXMLDocumentController getController() {
		return controller;
	}

	public void setController(FXMLDocumentController controller) {
		this.controller = controller;
	}

}
