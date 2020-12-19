package LogicaDeNegocio;

public class Contacto {

    private int puerto;
    private String host;
    private String mensaje;


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

    public Contacto(int puerto, String host, String mensaje) {
        this.puerto = puerto;
        this.host = host;
        this.mensaje = mensaje;
    }

}
