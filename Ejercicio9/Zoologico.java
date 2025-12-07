/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio9;

import java.util.Scanner;

/**
 *
 * @author Doghymen
 */
public class Zoologico {

    private int id;
    private String nombre;
    private int nroAnimales;
    private Animal[] animales;

    public Zoologico() {
        animales = new Animal[30];
        nroAnimales = 0;
    }

    public void leer(Scanner sc) {
        System.out.print("ID: ");
        id = sc.nextInt();
        System.out.print("Nombre: ");
        nombre = sc.next();
        System.out.print("Número de animales: ");
        nroAnimales = sc.nextInt();
        for (int i = 0; i < nroAnimales; i++) {
            animales[i] = new Animal();
            animales[i].leer(sc);
        }
    }

    public void mostrar() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Nro Animales: " + nroAnimales);
        for (int i = 0; i < nroAnimales; i++) {
            animales[i].mostrar();
        }
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNroAnimales() {
        return nroAnimales;
    }

    public Animal[] getAnimales() {
        return animales;
    }

    public void setNroAnimales(int n) {
        nroAnimales = n;
    }
}
