/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio10;

/**
 *
 * @author Doghymen
 */
public class Empresa {

    private String nombre;
    private String rubro;
    private int numeroEmpleados;

    public Empresa() {
        nombre = "";
        rubro = "";
        numeroEmpleados = 0;
    }

    public Empresa(String nombre, String rubro, int numeroEmpleados) {
        this.nombre = nombre;
        this.rubro = rubro;
        this.numeroEmpleados = numeroEmpleados;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRubro() {
        return rubro;
    }

    public int getNumeroEmpleados() {
        return numeroEmpleados;
    }

    public String toString() {
        return nombre + "," + rubro + "," + numeroEmpleados;
    }
}
