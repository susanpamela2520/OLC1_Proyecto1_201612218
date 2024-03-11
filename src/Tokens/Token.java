
package Tokens;

/**
 *
 * @author pamel
 */
public class Token {
 
 private String token;
    private int fila;
    private int columna;

    public Token(String token, int fila, int columna) {
        this.token = token;
        this.fila = fila;
        this.columna = columna;
    }

    // Métodos getter para acceder a los atributos

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }   
}
