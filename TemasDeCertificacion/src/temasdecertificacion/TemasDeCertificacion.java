package temasdecertificacion;

import ClasesInternas.Libro;
import ClasesInternas.Libro.Escritor;
import Interfaces.Cuadrado;
import java.util.Date;

public class TemasDeCertificacion {

    public static void main(String[] args) {

        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        //CLASES INTERNAS
        
        //Creo un libro comunmente
        Libro harryPotter = new Libro("HarryPotter", new Date("11/08/1980"), "Genero", "12000");
        //Puedo asignarle un nombre a su escritor, pero no puedo crear un escritor directamente sin pasar por la instancia

        harryPotter.getEscritor().setApellido("Perrala");
        //Creo un escritor, notar que para crear una instancia de la clase interna se necesita una instancia de la externa
        //es decir no puedo crear un escritor sino.

        Libro.Escritor e = harryPotter.new Escritor("Josheph", "Lar", new Date("11/08/1980"), false, new Date("11/08/1989"));

        //Puedo tambien obtener datos de la clase externa desde la interna pasando por un metodo intermedio.
        //Llamamos al numero de objeto creado por la clase externa desde la clase interna
        Libro.Escritor escritorNuevo = new Libro().new Escritor();
        escritorNuevo.numeroDeObjetoExterno();

        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||        
        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        //INTERFACES 
        
        Cuadrado cuadradoRelleno10x10 = new Cuadrado(10,10,true);
        Cuadrado cuadradoVacio10x10 = new Cuadrado(10,10,false);
        
        cuadradoVacio10x10.dibujar();
        cuadradoRelleno10x10.dibujar();
    }
}
