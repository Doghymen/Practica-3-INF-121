/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio5;

import java.util.Scanner;

/**
 *
 * @author Doghymen
 */
public class Medicamento {

    private String nombre;
    private int codMedicamento;
    private String tipo;
    private double precio;

    public Medicamento() {
    }

    public void leer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre: ");
        nombre = sc.next();
        System.out.print("Código: ");
        codMedicamento = sc.nextInt();
        System.out.print("Tipo: ");
        tipo = sc.next();
        System.out.print("Precio: ");
        precio = sc.nextDouble();
    }

    public void mostrar() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Código: " + codMedicamento);
        System.out.println("Tipo: " + tipo);
        System.out.println("Precio: " + precio);
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codMedicamento;
    }

}
