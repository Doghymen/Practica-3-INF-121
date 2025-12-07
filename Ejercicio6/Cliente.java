/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio6;

/**
 *
 * @author Doghymen
 */
public class Cliente {

    private int codCliente;
    private int ci;
    private String nombre;
    private String apellido;

    public Cliente(int codCliente, String nombre, String apellido, String perez) {
        this.codCliente = codCliente;
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public String toString() {
        return codCliente + "," + ci + "," + nombre + "," + apellido;
    }
}
