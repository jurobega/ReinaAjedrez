package org.iesalandalus.programacion.reinaajedrez.modelo;

import java.util.Objects;

public class Posicion {

    private int fila;
    private char columna;

    public Posicion(int fila , char columna ) {
        setFila(fila);
        setColumna(columna);
    }

    public Posicion(Posicion posicion ){
        Objects.requireNonNull(posicion, "ERROR: No es posible copiar una posición nula.");
        fila = posicion.fila;
        columna = posicion.columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
       if (fila < 1 || fila > 8){
           throw new IllegalArgumentException("ERROR: Fila no válida.");
       }
       this.fila = fila;
    }

    public char getColumna() {
        return columna;
    }

    public void setColumna(char columna) {
        if (columna < 'a' || columna > 'h') {
            throw new IllegalArgumentException("ERROR: Columna no válida.");
        }
        this.columna = columna;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posicion posicion = (Posicion) o;
        return fila == posicion.fila && columna == posicion.columna;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fila, columna);
    }

    @Override
    public String toString() {
        return String.format("fila=%s, columna=%s", fila, columna);
    }
}
