package Ejercicio2;

/**
 * <p>La clase Password proporciona funcionalidades para crear y validar contrasenyas</p>
 * <p>Este clase genera contrasenyas aleatorias y verifica su fortaleza</p>
 *
 * @author Filca
 * @version 1.5
 */
public final class Password {
    private final static int LONG_DEF = 8;

    private int longitud;

    private String contrasenya;

    /**
     * Devuelve la longitud de la contrasenya
     *
     * @return longitud de la contrasenya
     */
    public int getLongitud() {
        return longitud;
    }

    /**
     * Establece la longitud de la contrasenya
     *
     * @param longitud longitud de la contrasenya
     */
    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    /**
     * Devuelve la contrasenya.
     *
     * @return contrasenya
     */
    public String getContrasenya() {
        return contrasenya;
    }

    /**
     * Genera una contrasenya aleatoria.
     *
     * @see Math#random()
     * @see Math#floor(double)
     * @return contrasenya generada
     */
    public String generaPassword() {
        String password = "";
        for (int i = 0; i < longitud; i++) {
            int eleccion = ((int) Math.floor(Math.random() * 3 + 1));

            if (eleccion == 1) {
                char minusculas = (char) ((int) Math.floor(Math.random() * (123 - 97) + 97));
                password += minusculas;
            } else {
                if (eleccion == 2) {
                    char mayusculas = (char) ((int) Math.floor(Math.random() * (91 - 65) + 65));
                    password += mayusculas;
                } else {
                    char numeros = (char) ((int) Math.floor(Math.random() * (58 - 48) + 48));
                    password += numeros;
                }
            }
        }
        return password;
    }

    /**
     * Verifica si la contrasenya es fuerte.
     *
     * @see String#charAt(int)
     * @return true si la contrasenya es fuerte, false en caso contrario
     */
    public boolean esFuerte() {
        int cuentanumeros = 0;
        int cuentaminusculas = 0;
        int cuentamayusculas = 0;

        for (int i = 0; i < contrasenya.length(); i++) {
            if (contrasenya.charAt(i) >= 97 && contrasenya.charAt(i) <= 122) {
                cuentaminusculas += 1;
            } else {
                if (contrasenya.charAt(i) >= 65 && contrasenya.charAt(i) <= 90) {
                    cuentamayusculas += 1;
                } else {
                    cuentanumeros += 1;
                }
            }
        }
        if (cuentanumeros >= 5 && cuentaminusculas >= 1 && cuentamayusculas >= 2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Verifica si la contrasenya es fuerte.
     *
     * @deprecated (desde la version 1.2) Reemplazado por {@link #esFuerte()}
     * @return true si la contrasenya es fuerte, false en caso contrario
     */
    public boolean esFort() {
        int cuentanumeros = 0;
        int cuentaminusculas = 0;
        int cuentamayusculas = 0;

        for (int i = 0; i < contrasenya.length(); i++) {
            if (contrasenya.charAt(i) >= 97 && contrasenya.charAt(i) <= 122) {
                cuentaminusculas += 1;
            } else {
                if (contrasenya.charAt(i) >= 65 && contrasenya.charAt(i) <= 90) {
                    cuentamayusculas += 1;
                } else {
                    cuentanumeros += 1;
                }
            }
        }
        if (cuentanumeros >= 3 && cuentaminusculas >= 1 && cuentamayusculas >= 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Constructor por defecto de Password.
     */
    public Password() {
        this(LONG_DEF);
    }

    /**
     * Constructor de Password con longitud especificada.
     *
     * @param longitud longitud de la contrasenya
     */
    public Password(int longitud) {
        this.longitud = longitud;
        contrasenya = generaPassword();
    }
    }