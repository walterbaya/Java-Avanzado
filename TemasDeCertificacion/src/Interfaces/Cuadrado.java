package Interfaces;

public class Cuadrado implements Dibujable {

    private int trazosAlto;
    private int trazosLargo;
    private boolean relleno;

    public Cuadrado(int trazosAlto, int trazosLargo, boolean relleno) {
        this.relleno = relleno;
        this.trazosAlto = trazosAlto;
        this.trazosLargo = trazosLargo;
    }

    //La complejidad de esto es cuadratica es polinomial.
    @Override
    public void dibujar() {
        String matriz[][] = new String[trazosAlto][trazosLargo];
        if (relleno == true) {
            for (int i = 0; i < trazosAlto; i++) {
                for (int j = 0; j < trazosLargo; j++) {
                    System.out.print("x");
                }
                System.out.print("\n");
            }
        }

        if (relleno == false) {
            for (int i = 0; i < trazosAlto; i++) {
                for (int j = 0; j < trazosLargo; j++) {
                    if (i == trazosAlto - 1 || i == 0 || j == 0 || j == trazosLargo - 1) {
                        System.out.print("x");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.print("\n");
            }
        }
    }
}
