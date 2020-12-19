package EnumeradosYGenerics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Genericos {

    public static void main(String[] args) {
        ArrayList<String> propiedades = new ArrayList<String>();
        propiedades.add("casa1");
        propiedades.add("departamento1");
        propiedades.add("casa2");
        propiedades.add("casa3");
        propiedades.add("departamento2");
        propiedades.add("casa4");
        propiedades.add("Terreno5");
        propiedades.add("departamento3");
        propiedades.add("casa7");

        HashMap<Hogares, String> propiedadesConIndicador = new HashMap<Hogares, String>();
        Iterator<String> iteratorPropiedades = propiedades.iterator();
        while (iteratorPropiedades.hasNext()) {
            String proximo = iteratorPropiedades.next();
            if (iteratorPropiedades.next().contains("casa")) {
                propiedadesConIndicador.put(Hogares.CASA, proximo);
            } else if (iteratorPropiedades.next().contains("departamento")) {
                propiedadesConIndicador.put(Hogares.DEPARTAMENTO, proximo);
            } else {
                propiedadesConIndicador.put(Hogares.TERRENO, proximo);
            }
        }
    }
}
