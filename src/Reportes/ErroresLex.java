/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reportes;

/**
 *
 * @author pamel
 */
public class ErroresLex {
    private String tipo_Error;
    private String descripcion;
    private int linea;
    private int columna;

    public ErroresLex(String tipo_Error, String descripcion, int linea, int columna) {
        this.tipo_Error = tipo_Error;
        this.descripcion = descripcion;
        this.linea = linea;
        this.columna = columna;
    }

    public String getTipo_Error() {
        return tipo_Error;
    }

    public void setTipo_Error(String tipo_Error) {
        this.tipo_Error = tipo_Error;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        return "Error Lexico{" + "tipo_Error=" + tipo_Error + ", descripcion=" + descripcion + ", linea=" + linea + ", columna=" + columna + '}';
    }
    
}
