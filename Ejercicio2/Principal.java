/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

/**
 *
 * @author Doghymen
 */
public class Principal {

    public static void main(String[] args) {

        ArchivoTrabajador archivo = new ArchivoTrabajador();

        // a)
        archivo.crearArchivo();

        Trabajador t1 = new Trabajador("Ana", 111, 2500);
        Trabajador t2 = new Trabajador("Luis", 222, 3000);
        Trabajador t3 = new Trabajador("Maria", 333, 2800);

        // b)
        archivo.guardarTrabajador(t1);
        archivo.guardarTrabajador(t2);
        archivo.guardarTrabajador(t3);

        archivo.aumentaSalario(500, t1);
        // d)
        Trabajador mayor = archivo.mayorSalario();
        System.out.println("Trabajador con mayor salario:");
        System.out.println(mayor);

        // e)
        archivo.ordenarPorSalario();
        System.out.println("Trabajadores ordenados por salario:");

        System.out.println("---- LISTA ----");
        for (Trabajador t : archivoTest(archivo)) {
            System.out.println(t);
        }
    }

    private static java.util.ArrayList<Trabajador> archivoTest(ArchivoTrabajador arch) {
        try {
            java.lang.reflect.Method m = ArchivoTrabajador.class.getDeclaredMethod("leerTrabajadores");
            m.setAccessible(true);
            return (java.util.ArrayList<Trabajador>) m.invoke(arch);
        } catch (Exception e) {
            return new java.util.ArrayList<>();
        }
    }
}
