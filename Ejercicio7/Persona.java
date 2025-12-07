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
public class Persona {

    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int ci;

    public Persona() {
    }

    public void leer(Scanner sc) {
        System.out.print("Nombre: ");
        nombre = sc.next();
        System.out.print("Apellido Paterno: ");
        apellidoPaterno = sc.next();
        System.out.print("Apellido Materno: ");
        apellidoMaterno = sc.next();
        System.out.print("CI: ");
        ci = sc.nextInt();
    }

    public void mostrar() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido Paterno: " + apellidoPaterno);
        System.out.println("Apellido Materno: " + apellidoMaterno);
        System.out.println("CI: " + ci);
    }

    public int getCi() {
        return ci;
    }
}
