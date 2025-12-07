/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio9;

import java.util.Scanner;

/**
 *
 * @author Doghymen
 */
public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArchZoo arch = new ArchZoo(50);

        arch.crear(sc);
        System.out.println("Zoológicos con mayor variedad:");
        arch.mayorVariedad();

        System.out.println("Eliminar vacíos:");
        arch.eliminarVacios();

        System.out.print("Especie a buscar: ");
        String x = sc.next();
        arch.mostrarEspecie(x);

        System.out.print("Mover animales de id X: ");
        int id1 = sc.nextInt();
        System.out.print("A id Y: ");
        int id2 = sc.nextInt();
        arch.mover(id1, id2);
    }
}
