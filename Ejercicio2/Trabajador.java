/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

import java.io.Serializable;
/**
 *
 * @author Doghymen
 */
public class Trabajador implements Serializable {

    private String nombre;
    private int carnet;
    private double salario;

    public Trabajador() {
    }

    public Trabajador(String nombre, int carnet, double salario) {
        this.nombre = nombre;
        this.carnet = carnet;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return nombre + " - " + carnet + " - " + salario;
    }
}
