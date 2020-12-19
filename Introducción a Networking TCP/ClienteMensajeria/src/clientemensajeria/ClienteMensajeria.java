package clientemensajeria;

import LogicaDeNegocio.ReceptorDeMensajes;
import java.io.IOException;
import java.net.UnknownHostException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ClienteMensajeria extends Application {

    private Stage escenarioPrincipal;
    private FXMLDocumentController controller;
    

    @Override
    public void start(Stage escenarioPrincipal) throws IOException {
        this.escenarioPrincipal = escenarioPrincipal;
        escenarioPrincipal.setTitle("Ventana Principal");
        iniciarVentanaMaestra();
        
        ReceptorDeMensajes servidor = new ReceptorDeMensajes(4300, controller);
        Thread hiloServidor = new Thread(servidor);
        hiloServidor.start(); 
    }

    private void iniciarVentanaMaestra() throws IOException {

        FXMLLoader cargador = new FXMLLoader();

        cargador.setLocation(getClass().getResource("FXMLDocument.fxml"));
        AnchorPane disenioDeLaVentana = (AnchorPane) cargador.load();

        controller = cargador.getController();
        controller.setRunner(this);
        Scene escenaPrincipal = new Scene(disenioDeLaVentana, 592, 489);
        escenarioPrincipal.setScene(escenaPrincipal);
        escenarioPrincipal.sizeToScene();
        escenarioPrincipal.setResizable(false);
        escenarioPrincipal.show();
                
    }


    public static void main(String[] args) throws UnknownHostException {
        launch(args);
    }

}
