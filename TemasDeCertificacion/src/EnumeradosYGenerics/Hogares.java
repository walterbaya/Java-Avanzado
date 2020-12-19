package EnumeradosYGenerics;

public enum Hogares {
    CASA(3), DEPARTAMENTO(2), TERRENO(0);

    private int numeroHabitaciones;

    Hogares(int numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public int numeroHabitaciones(Hogares a) {
        return a.numeroHabitaciones;
    }

}
