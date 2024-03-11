/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reportes;

/**
 *
 * @author pamel
 */
public class Token {
    private String Lexema;
    private String tipo;
    private int linea;
    private int columna;

    public Token(String Lexema, String tipo, int linea, int columna) {
        this.Lexema = Lexema;
        this.tipo = tipo;
        this.linea = linea;
        this.columna = columna;
    }

    public String getLexema() {
        return Lexema;
    }

    public void setLexema(String Lexema) {
        this.Lexema = Lexema;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    @Override
    public String toString() {
        return "Tokens {" + "Lexema=" + Lexema + ", tipo=" + tipo + ", linea=" + linea + ", columna=" + columna + '}';
    }

    
}
