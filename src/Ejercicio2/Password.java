package Ejercicio2;

/**
 * <p>La clase Password proporciona funcionalidades para crear y validar contraseñas</p>
 * <p>Este clase genera contraseñas aleatorias y verifica su fortaleza</p>
 *
 * @author Filca
 * @version 1.5
 */
public final class Password {
    private final static int LONG_DEF = 8;

    private int longitud;

    private String contraseña;

    /**
     * Devuelve la longitud de la contraseña
     *
     * @return longitud de la contraseña
     */
    public int getLongitud() {
        return longitud;
    }

    /**
     * Establece la longitud de la contraseña
     *
     * @param longitud longitud de la contraseña
     */
    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    /**
     * Devuelve la contraseña.
     *
     * @return contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Genera una contraseña aleatoria.
     *
     * @see Math#random()
     * @see Math#floor(double)
     * @return contraseña generada
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
     * Verifica si la contraseña es fuerte.
     *
     * @see String#charAt(int)
     * @return true si la contraseña es fuerte, false en caso contrario
     */
    public boolean esFuerte() {
        int cuentanumeros = 0;
        int cuentaminusculas = 0;
        int cuentamayusculas = 0;

        for (int i = 0; i < contraseña.length(); i++) {
            if (contraseña.charAt(i) >= 97 && contraseña.charAt(i) <= 122) {
                cuentaminusculas += 1;
            } else {
                if (contraseña.charAt(i) >= 65 && contraseña.charAt(i) <= 90) {
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
     * Verifica si la contraseña es fuerte.
     *
     * @deprecated (desde la versión 1.2) Reemplazado por {@link #esFuerte()}
     * @return true si la contraseña es fuerte, false en caso contrario
     */
    public boolean esFort() {
        int cuentanumeros = 0;
        int cuentaminusculas = 0;
        int cuentamayusculas = 0;

        for (int i = 0; i < contraseña.length(); i++) {
            if (contraseña.charAt(i) >= 97 && contraseña.charAt(i) <= 122) {
                cuentaminusculas += 1;
            } else {
                if (contraseña.charAt(i) >= 65 && contraseña.charAt(i) <= 90) {
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
     * @param longitud longitud de la contraseña
     */
    public Password(int longitud) {
        this.longitud = longitud;
        contraseña = generaPassword();
    }
    }