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
public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArchRefri r = new ArchRefri(100);

        r.crear(sc);
        System.out.println("Listado:");
        r.listar();

        System.out.print("Modificar alimento con nombre: ");
        String m = sc.next();
        r.modificarPorNombre(m, sc);

        System.out.print("Eliminar alimento con nombre: ");
        String e = sc.next();
        r.eliminarPorNombre(e);

        System.out.print("Mostrar caducados antes de: ");
        String x = sc.next();
        r.mostrarCaducadosAntes(x);

        r.eliminarCantidadCero();

        System.out.print("Buscar vencidos. Fecha hoy (AAAAMMDD): ");
        String hoy = sc.next();
        r.buscarVencidos(hoy);

        System.out.println("Alimento con mayor cantidad:");
        r.mostrarMayorCantidad();
    }
}
