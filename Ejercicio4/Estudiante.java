/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

import java.io.Serializable;

/**
 *
 * @author Doghymen
 */
public class Estudiante implements Serializable {
    private int ru;
    private String nombre;
    private String paterno;
    private String materno;
    private int edad;

    public Estudiante(int ru, String nombre, String paterno, String materno, int edad) {
        this.ru = ru;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.edad = edad;
    }

    public int getRu() {
        return ru;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public int getEdad() {
        return edad;
    }

    public String toString() {
        return "RU: " + ru + ", " + nombre + " " + paterno + " " + materno + ", Edad: " + edad;
    }
}
