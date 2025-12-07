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
public class Nota implements Serializable {
    private String materia;
    private float notaFinal;
    private Estudiante estudiante;

    public Nota(String materia, float notaFinal, Estudiante estudiante) {
        this.materia = materia;
        this.notaFinal = notaFinal;
        this.estudiante = estudiante;
    }

    public String getMateria() {
        return materia;
    }

    public float getNotaFinal() {
        return notaFinal;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public String toString() {
        return "Materia: " + materia + ", Nota Final: " + notaFinal + ", Estudiante: [" + estudiante + "]";
    }
}
