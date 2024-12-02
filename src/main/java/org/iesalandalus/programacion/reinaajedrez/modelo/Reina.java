package org.iesalandalus.programacion.reinaajedrez.modelo;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class Reina {
    private Color color;
    private Posicion posicion;

    public Reina() {
        color = Color.BLANCO;
        posicion = new Posicion(1 , 'd');
    }

    public Reina(Color color) {
        setColor(color);
        if (color == Color.BLANCO ){
            posicion = new Posicion(1,'d');
        }else if (color == Color.NEGRO ){
            posicion = new Posicion(8,'d');
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        Objects.requireNonNull(color,"ERROR: El color no puede ser nulo.");
        try {
            this.color = color;
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error: color no válido.");
        }
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        try {
            this.posicion = posicion;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error: posición no válida." +e.getMessage());
        }
    }

    public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException {
        Objects.requireNonNull(direccion,"ERROR: La dirección no puede ser nula.");
        if (pasos < 1 || pasos > 7 ){
            throw new IllegalArgumentException("ERROR: El número de pasos debe estar comprendido entre 1 y 7.");
        }
        int nuevaFila = posicion.getFila() ;
        char nuevaColumna = posicion.getColumna();
        switch (direccion){
            case NORTE -> nuevaFila = posicion.getFila() + pasos;
            case NORESTE -> {nuevaFila = posicion.getFila() + pasos; nuevaColumna = (char) (posicion.getColumna() + pasos);}
            case ESTE -> nuevaColumna = (char) ( posicion.getColumna() + pasos );
            case SURESTE -> { nuevaFila = posicion.getFila() - pasos; nuevaColumna = (char) (posicion.getColumna() + pasos ); }
            case SUR -> nuevaFila = posicion.getFila() - pasos ;
            case SUROESTE -> { nuevaFila = posicion.getFila() - pasos ; nuevaColumna = (char) (posicion.getColumna() - pasos );}
            case OESTE -> nuevaColumna = (char) (posicion.getColumna() - pasos );
            case NOROESTE -> {nuevaFila = posicion.getFila() + pasos ; nuevaColumna = (char) (posicion.getColumna() - pasos );}
        }
        try {
            posicion = new Posicion(nuevaFila , nuevaColumna);
        }   catch (IllegalArgumentException e) {
            throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
        }
    }

    @Override
    public String toString() {
        return String.format("color=%s, posicion=(%s)", color, posicion);
    }
}
