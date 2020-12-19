package ClasesInternas;

import java.util.Date;

public class Libro {

    private String titulo;
    private Date fechaDeLanzamiento;
    private String genero;
    private String cantidadDePalabras;
    private Escritor escritor;

    public Libro() {

    }

    public Libro(String titulo, Date fechaDeLanzamiento, String genero, String cantidadDePalabras) {
        this.titulo = titulo;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
        this.genero = genero;
        this.cantidadDePalabras = cantidadDePalabras;
        this.escritor = new Escritor();
    }

    public class Escritor {

        private String nombre;
        private String apellido;
        private Date fechaNacimiento;
        private boolean vivo;
        private Date fechaFallecimiento;

        public Escritor() {
        }

        public Escritor(String nombre, String apellido, Date fechaNacimiento, boolean vivo, Date fechaFallecimiento) {
            this.apellido = apellido;
            this.nombre = nombre;
            this.fechaNacimiento = fechaNacimiento;
            this.fechaFallecimiento = fechaFallecimiento;
            this.vivo = vivo;
        }

        //Imprimir valores de la clase externa desde la clase interna usando la referencia this.
        public void numeroDeObjetoExterno() {
            System.out.println("El numero de objeto externo desde la clase interna es: " + Libro.this);
        }

        public String getNombre() {
            return nombre;
        }

        /**
         * @param nombre the nombre to set
         */
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        /**
         * @return the apellido
         */
        public String getApellido() {
            return apellido;
        }

        /**
         * @param apellido the apellido to set
         */
        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        /**
         * @return the fechaNacimiento
         */
        public Date getFechaNacimiento() {
            return fechaNacimiento;
        }

        /**
         * @param fechaNacimiento the fechaNacimiento to set
         */
        public void setFechaNacimiento(Date fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
        }

        /**
         * @return the vivo
         */
        public boolean isVivo() {
            return vivo;
        }

        /**
         * @param vivo the vivo to set
         */
        public void setVivo(boolean vivo) {
            this.vivo = vivo;
        }

        /**
         * @return the fechaFallecimiento
         */
        public Date getFechaFallecimiento() {
            return fechaFallecimiento;
        }

        /**
         * @param fechaFallecimiento the fechaFallecimiento to set
         */
        public void setFechaFallecimiento(Date fechaFallecimiento) {
            this.fechaFallecimiento = fechaFallecimiento;
        }

    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the fechaDeLanzamiento
     */
    public Date getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    /**
     * @param fechaDeLanzamiento the fechaDeLanzamiento to set
     */
    public void setFechaDeLanzamiento(Date fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the cantidadDePalabras
     */
    public String getCantidadDePalabras() {
        return cantidadDePalabras;
    }

    /**
     * @param cantidadDePalabras the cantidadDePalabras to set
     */
    public void setCantidadDePalabras(String cantidadDePalabras) {
        this.cantidadDePalabras = cantidadDePalabras;
    }

    /**
     * @return the escritor
     */
    public Escritor getEscritor() {
        return escritor;
    }

    /**
     * @param escritor the escritor to set
     */
    public void setEscritor(Escritor escritor) {
        this.escritor = escritor;
    }

}
