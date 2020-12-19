package clientemensajeria;

import LogicaDeNegocio.EnviarDeMensajes;
import LogicaDeNegocio.Contacto;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {

	private String texto;
	private String mensaje;
	private ArrayList<EnviarDeMensajes> listaDeThreads;
	// private HashMap<String, Thread> listaDeThreads;

	private ClienteMensajeria runner;

	@FXML
	private TextArea mensajesEntrantes;

	@FXML
	private TextArea mensajeRecibido;

	@FXML
	private TextField host;

	@FXML
	private TextField port;

	@FXML
	private TextArea listaDeContactos;

	public TextArea getListaDeContactos() {
		return listaDeContactos;
	}

	public void setListaDeContactos(TextArea listaDeContactos) {
		this.listaDeContactos = listaDeContactos;
	}

	public TextArea getMensajesEntrantes() {
		return mensajesEntrantes;
	}

	public void setMensajesEntrantes(TextArea aMensajesEntrantes) {
		mensajesEntrantes = aMensajesEntrantes;
	}

	public void setMensajesEntrantes(String aMensajesEntrantes) {
		mensajesEntrantes.setText(aMensajesEntrantes);
	}

	public TextArea getMensajeRecibido() {
		return mensajeRecibido;
	}

	public void setMensajeRecibido(TextArea aMensajeRecibido) {
		mensajeRecibido = aMensajeRecibido;
	}

	public TextField getHost() {
		return host;
	}

	public void setHost(TextField aHost) {
		host = aHost;
	}

	public TextField getPort() {
		return port;
	}

	public void setPort(TextField aPort) {
		port = aPort;
	}

	// Recorre toda la lista de Threads y los pone a funcionar.
	@FXML
	public void enviarMensaje() {
		for (int i = 0; i < listaDeThreads.size(); i++) {
			EnviarDeMensajes nuevo = (EnviarDeMensajes) listaDeThreads.get(i);
			Thread hilo = new Thread(nuevo);
			hilo.start();
		}
	}

	@FXML
	public void agregarContacto() {
		Integer entero = Integer.parseInt(port.getText());
		Contacto proximo = new Contacto(entero, host.getText(), mensajeRecibido.getText());
		EnviarDeMensajes clienteMensajero = new EnviarDeMensajes(entero, proximo.getHost(), proximo.getMensaje(), this);
		listaDeThreads.add(clienteMensajero);
		texto = texto + host.getText() + "\n";
		listaDeContactos.setText(texto);
	}

	public ClienteMensajeria getRunner() {
		return runner;
	}

	public void setRunner(ClienteMensajeria runner) {
		this.runner = runner;
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		texto = "";
		listaDeThreads = new ArrayList();
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
		this.mensajesEntrantes.setText(mensaje);
	}

}
