package org.iesalandalus.programacion.reinaajedrez.modelo;

public enum Color {
    BLANCO("Blanco"),
    NEGRO("Negro");

    private final String cadenaMostrar;

    private Color (String cadenaMostrar) {
        this.cadenaMostrar = cadenaMostrar;
    }

    @Override
    public String toString() {
        return String.format(cadenaMostrar);
    }
}
