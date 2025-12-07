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
public class Nino extends Persona {

    private int edad;
    private int peso;
    private int talla;

    public Nino() {
    }

    public void leer(Scanner sc) {
        super.leer(sc);
        System.out.print("Edad: ");
        edad = sc.nextInt();
        System.out.print("Peso: ");
        peso = sc.nextInt();
        System.out.print("Talla: ");
        talla = sc.nextInt();
    }

    public void mostrar() {
        super.mostrar();
        System.out.println("Edad: " + edad);
        System.out.println("Peso: " + peso);
        System.out.println("Talla: " + talla);
    }

    public int getEdad() {
        return edad;
    }

    public int getPeso() {
        return peso;
    }

    public int getTalla() {
        return talla;
    }
}
