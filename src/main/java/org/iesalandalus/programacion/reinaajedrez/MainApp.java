package org.iesalandalus.programacion.reinaajedrez;

import org.iesalandalus.programacion.reinaajedrez.modelo.Reina;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class MainApp {
    private static Reina reina;

    public static void main(String[] args) throws OperationNotSupportedException {
        int opcion;
        do {
            opcion = Consola.elegirOpcionMenu();
            ejecutarOpcion(opcion);
            mostrarReina(reina);
        }while (opcion != 4);
    }

    private static void ejecutarOpcion(int opcion) throws OperationNotSupportedException {
        switch (opcion) {
            case 1 -> crearReianDefecto();
            case 2 -> crearReinaColor();
            case 3 -> mover();
            case 4 -> Consola.despedirse();
            default ->throw new IllegalArgumentException("Opción no valida.");
        }
    }

    private static void crearReianDefecto() {
        reina = new Reina();
    }

    private static void crearReinaColor() {
        reina = new Reina(Consola.elegirColor());
    }

    private static void mover() throws OperationNotSupportedException {
        reina.mover(Consola.elegirDireccion(),Consola.elegirPasos());
    }

    private static void mostrarReina(Reina reina) {
        Objects.requireNonNull(reina,"La reina no puede ser nula.");
        System.out.println(reina);
    }
}
