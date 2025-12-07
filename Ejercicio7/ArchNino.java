/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio7;

import java.util.Scanner;

/**
 *
 * @author Doghymen
 */
public class ArchNino {

    private Nino[] na;
    private int n;

    public ArchNino(int tam) {
        na = new Nino[tam];
        n = 0;
    }

    public void crear(Scanner sc) {
        System.out.print("Cantidad de niños: ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Niño " + (i + 1) + ":");
            na[i] = new Nino();
            na[i].leer(sc);
        }
    }

    public void listar() {
        for (int i = 0; i < n; i++) {
            System.out.println("--- Niño " + (i + 1) + " ---");
            na[i].mostrar();
        }
    }

// b) 
    public int contarPesoAdecuado() {
        int c = 0;
        for (int i = 0; i < n; i++) {
            int e = na[i].getEdad();
            int p = na[i].getPeso();
            int t = na[i].getTalla();
            if (p == (e * 2) && t == (e * 10)) {
                c++;
            }
        }
        return c;
    }

// c) 
    public void mostrarNoAdecuados() {
        for (int i = 0; i < n; i++) {
            int e = na[i].getEdad();
            int p = na[i].getPeso();
            int t = na[i].getTalla();
            if (!(p == (e * 2) && t == (e * 10))) {
                na[i].mostrar();
            }
        }
    }

// d) 
    public double promedioEdad() {
        int suma = 0;
        for (int i = 0; i < n; i++) {
            suma += na[i].getEdad();
        }
        return (double) suma / n;
    }

// e) 
    public void buscarCi(int x) {
        boolean encontrado = false;
        for (int i = 0; i < n; i++) {
            if (na[i].getCi() == x) {
                na[i].mostrar();
                encontrado = true;
            }
        }

    }

    // f)
    public void mostrarTallaMasAlta() {
        int max = -1;
        for (int i = 0; i < n; i++) {
            if (na[i].getTalla() > max) {
                max = na[i].getTalla();
            }
        }
        for (int i = 0; i < n; i++) {
            if (na[i].getTalla() == max) {
                na[i].mostrar();
            }
        }
    }
}
