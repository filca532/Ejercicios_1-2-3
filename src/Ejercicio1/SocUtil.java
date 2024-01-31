package Ejercicio1;

/**
 * @author Filca
 * @version 2.15
 */
public class SocUtil {
    /**
     * Comprueba si un número es capicúa o no
     * @param numero El número a comprobar
     * @return Verdadero si el número es capicúa, falso en caso contrario
     * @throws EsNegatiuEX Si el número es negativo
     * @deprecated Desde la versión 1.23, reemplazado por {@link #esCapikua(int)}
     */
    public static boolean esCapicua(int numero) throws EsNegatiuEX {
        if (numero < 0) {
            throw new EsNegatiuEX();
        }
        int numAlReves = 0;
        int copia = numero;
        while (numero > 0) {
            numAlReves = numAlReves * 10 + numero % 10;
            numero /= 10;
        }
        return copia == numAlReves;
    }

    /**
     * Comprueba si un número es capicúa utilizando cadenas de texto.
     * @param numero El número a comprobar
     * @return Verdadero si el número es capicúa, falso en caso contrario
     * @throws EsNegatiuEX Si el número es negativo
     */
    public static boolean esCapikua(int numero) throws EsNegatiuEX {
        if (numero < 0) {
            throw new EsNegatiuEX();
        }
        String cadNum = numero + "";
        String numAlReves = (new StringBuilder(cadNum)).reverse().toString();
        return cadNum.equals(numAlReves);
    }

    /**
     * Comprueba si un número es primo
     * @param numero El número a comprobar
     * @return Verdadero si el número es primo, falso en caso contrario
     * @throws EsNegatiuEX Si el número es negativo
     */
    public static boolean esPrimer(int numero) throws EsNegatiuEX {
        if (numero < 0) {
            throw new EsNegatiuEX();
        }
        int limit = numero / 2 + 1;
        int div = 2;
        while (div < limit) {
            if (numero % div == 0){
                return false;
            }
            div++;
        }
        return true;
    }

    /**
     * Calcula el factorial de un número.
     * @param numero El número del que se calculará el factorial.
     * @return El factorial del número.
     * @throws EsNegatiuEX Si el número es negativo.
     * @see <a href="http://www.sangakoo.com/es/temas/el-factorial-de-un-numero" target="_blank">Sangaku Maths</a>
     */
    public static long getFactorial(int numero) throws EsNegatiuEX {
        if (numero < 0) {
            throw new EsNegatiuEX("no es pot calcular el factorial d'un número negatiu");
        }
        long fact = 1L;
        while (numero > 1) {
            fact *= numero;
            numero--;
        }
        return fact;
    }
}
