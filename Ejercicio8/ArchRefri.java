/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio8;

import java.util.Scanner;

/**
 *
 * @author Doghymen
 */
class ArchRefri {

    private Alimento[] a;
    private int n;
    private String nombre;

    public ArchRefri(int tam) {
        a = new Alimento[tam];
        n = 0;
    }

    public void crear(Scanner sc) {
        System.out.print("Cantidad de alimentos: ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Alimento " + (i + 1) + ":");
            a[i] = new Alimento();
            a[i].leer(sc);
        }
    }

    public void listar() {
        for (int i = 0; i < n; i++) {
            System.out.println("--- Alimento " + (i + 1) + " ---");
            a[i].mostrar();
        }
    }

// a) Modificar por nombre
    public void modificarPorNombre(String x, Scanner sc) {
        for (int i = 0; i < n; i++) {
            if (a[i].getNombre().equals(x)) {
                System.out.println("Modificar fecha: ");
                String f = sc.next();
                a[i].setFecha(f);
                System.out.println("Modificar cantidad: ");
                int c = sc.nextInt();
                a[i].setCantidad(c);
            }
        }
    }

// a) Eliminar por nombre
    public void eliminarPorNombre(String x) {
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (!a[i].getNombre().equals(x)) {
                a[j] = a[i];
                j++;
            }
        }
        n = j;
    }

// b) Mostrar alimentos que caducaron antes de fecha X
    public void mostrarCaducadosAntes(String x) {
        for (int i = 0; i < n; i++) {
            if (a[i].getFecha().compareTo(x) < 0) {
                a[i].mostrar();
            }
        }
    }

// c) Eliminar alimentos con cantidad 0
    public void eliminarCantidadCero() {
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (a[i].getCantidad() != 0) {
                a[j] = a[i];
                j++;
            }
        }
        n = j;
    }

// d) Buscar alimentos vencidos (fecha < hoy)
    public void buscarVencidos(String hoy) {
        for (int i = 0; i < n; i++) {
            if (a[i].getFecha().compareTo(hoy) < 0) {
                a[i].mostrar();
            }
        }
    }

// e) Mostrar alimento con mayor cantidad
    public void mostrarMayorCantidad() {
        int max = -1;
        for (int i = 0; i < n; i++) {
            if (a[i].getCantidad() > max) {
                max = a[i].getCantidad();
            }
        }
        for (int i = 0; i < n; i++) {
            if (a[i].getCantidad() == max) {
            }

        }

    }
}