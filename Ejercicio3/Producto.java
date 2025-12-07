/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

import java.io.Serializable;

/**
 *
 * @author Doghymen
 */
public class Producto implements Serializable {

    private int codigo;
    private String nombre;
    private float precio;

    public Producto(int codigo, String nombre, float precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String toString() {
        return "Codigo: " + codigo + ", Nombre: " + nombre + ", Precio: " + precio;
    }
}
