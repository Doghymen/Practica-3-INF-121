/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio7;

import java.util.Scanner;

/**
 *
 * @author Doghymen
 */
public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArchNino a = new ArchNino(100);

        a.crear(sc);
        System.out.println("\nListado:");
        a.listar();

        System.out.println("\nNinos con peso adecuado: " + a.contarPesoAdecuado());

        System.out.println("\nNinns no adecuados:");
        a.mostrarNoAdecuados();

        System.out.println("\nPromedio edad: " + a.promedioEdad());

        System.out.print("\nBuscar CI: ");
        int x = sc.nextInt();
        a.buscarCi(x);

        System.out.println("\nNiños con talla mas alta:");
        a.mostrarTallaMasAlta();
    }
}
