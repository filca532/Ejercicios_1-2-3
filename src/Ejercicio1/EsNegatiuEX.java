package Ejercicio1;

/**
 * @author Filca
 * @version 2.14
 */
public class EsNegatiuEX extends Exception {
    public EsNegatiuEX() {
        super("el valor no pot ser negatiu");
    }

    public EsNegatiuEX(String msg) {
        super(msg);
    }
}
