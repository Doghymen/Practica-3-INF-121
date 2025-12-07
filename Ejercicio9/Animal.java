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
public class Animal {

    private String especie;
    private String nombre;
    private int cantidad;

    public Animal() {
    }

    public void leer(Scanner sc) {
        System.out.print("Especie: ");
        especie = sc.next();
        System.out.print("Nombre: ");
        nombre = sc.next();
        System.out.print("Cantidad: ");
        cantidad = sc.nextInt();
    }

    public void mostrar() {
        System.out.println("Especie: " + especie);
        System.out.println("Nombre: " + nombre);
        System.out.println("Cantidad: " + cantidad);
    }

    public String getEspecie() {
        return especie;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int c) {
        cantidad = c;
    }
}
