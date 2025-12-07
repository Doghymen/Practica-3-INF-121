/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

/**
 *
 * @author Doghymen
 */
public class Principal {

    public static void main(String[] args) {

        ArchiNota arch = new ArchiNota("notas.dat");

        // a)
        // b)
        Estudiante e1 = new Estudiante(1, "Juan", "Perez", "Lopez", 20);
        Estudiante e2 = new Estudiante(2, "Maria", "Quispe", "Mamani", 22);
        Estudiante e3 = new Estudiante(3, "Luis", "Condori", "Choque", 19);
        Estudiante e4 = new Estudiante(4, "Ana", "Flores", "Catari", 21);

        Nota n1 = new Nota("Matemáticas", 85, e1);
        Nota n2 = new Nota("Matemáticas", 95, e2);
        Nota n3 = new Nota("Física", 75, e3);
        Nota n4 = new Nota("Matemáticas", 95, e4);

        arch.agregarNota(n1);
        arch.agregarNota(n2);
        arch.agregarNota(n3);
        arch.agregarNota(n4);

        System.out.println("Datos registrados correctamente.");

        // c)
        float promedio = arch.promedioNotas();
        System.out.println("Promedio general de notas: " + promedio);

        // d)
        System.out.println("Estudiante(s) con la mejor nota:");
        arch.mejorNota();

        // e)
        arch.eliminarMateria("Matemáticas");
        System.out.println("Se eliminaron los estudiantes de Matemáticas.");

        float nuevoPromedio = arch.promedioNotas();
        System.out.println("Nuevo promedio después de eliminar materia: " + nuevoPromedio);
    }
}
