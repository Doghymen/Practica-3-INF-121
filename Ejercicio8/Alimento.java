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
public class Alimento {

    private String nombre;
    private String fechaVencimiento;
    private int cantidad;

    public Alimento() {
    }

    public void leer(Scanner sc) {
        System.out.print("Nombre: ");
        nombre = sc.next();
        System.out.print("Fecha de vencimiento (AAAAMMDD): ");
        fechaVencimiento = sc.next();
        System.out.print("Cantidad: ");
        cantidad = sc.nextInt();
    }

    public void mostrar() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Fecha Vencimiento: " + fechaVencimiento);
        System.out.println("Cantidad: " + cantidad);
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fechaVencimiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int c) {
        cantidad = c;
    }

    public void setFecha(String f) {
        fechaVencimiento = f;
    }
}
