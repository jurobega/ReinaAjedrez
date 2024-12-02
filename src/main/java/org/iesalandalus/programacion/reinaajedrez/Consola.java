package org.iesalandalus.programacion.reinaajedrez;

import org.iesalandalus.programacion.reinaajedrez.modelo.Color;
import org.iesalandalus.programacion.reinaajedrez.modelo.Direccion;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
    private Consola(){}

    public static void mostrarMenu() {
        System.out.println("------Menu-------");
        System.out.println("1-Controlar Reina por defecto.");
        System.out.println("2-Controlar Reina eligiendo el color.");
        System.out.println("3-Mover reina.");
        System.out.println("4-Despedirse.");
    }

    public static int elegirOpcionMenu() {
        mostrarMenu();
        int opcion;
        do {
            System.out.println("Elige una opción: ");
            opcion = Entrada.entero();
        }while (opcion < 1 || opcion > 3);
        return opcion;
    }

    public static Color elegirColor() {
        System.out.println("0-Blanco.");
        System.out.println("1-Negro");
        int opcion;
        do {
            System.out.println("Elige un color: ");
            opcion = Entrada.entero();
        }while (opcion < 1 || opcion > 2 );
        return Color.values()[opcion];
    }

    public static void mostrarMenuDirecciones() {
        System.out.println("0-Norte.");
        System.out.println("1-Noreste");
        System.out.println("2-Este.");
        System.out.println("3-Sureste.");
        System.out.println("4-Sur.");
        System.out.println("5-Suroeste.");
        System.out.println("6-Oeste.");
        System.out.println("7-Noroeste.");
    }

    public static Direccion elegirDireccion() {
        mostrarMenuDirecciones();
        int opciones;
        do {
            System.out.print("Elige una dirección: ");
            opciones = Entrada.entero();
        } while ( opciones < 0 || opciones > 7 );
        return Direccion.values()[opciones];
    }

    public static int elegirPasos() {
        int pasos;
        System.out.print("Cuantos pasos quieres moverte: ");
        pasos = Entrada.entero();
        return pasos;
    }

    public static void despedirse() {
        System.out.println("Se ha cerrado el programa.");
    }
}
