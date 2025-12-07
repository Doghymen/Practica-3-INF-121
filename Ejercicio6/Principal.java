/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio6;

import java.util.ArrayList;

/**
 *
 * @author Doghymen
 */
public class Principal {

    public static void main(String[] args) {

        ArchLibro archL = new ArchLibro("libros.txt");
        ArchCliente archC = new ArchCliente("clientes.txt");
        ArchPrestamo archP = new ArchPrestamo("prestamos.txt");

        archL.agregar(new Libro(1, "Java", 100));
        archL.agregar(new Libro(2, "Python", 150));
        archL.agregar(new Libro(3, "C++", 90));

        archC.agregar(new Cliente(1, "123", "Juan", "Perez"));
        archC.agregar(new Cliente(2, "456", "Maria", "Lopez"));

        archP.agregar(new Prestamo(1, 1, "2024-01-10", 2));
        archP.agregar(new Prestamo(2, 1, "2024-01-11", 1));
        archP.agregar(new Prestamo(1, 2, "2024-01-12", 3));

        ArrayList<Libro> L = archL.leerTodos();
        ArrayList<Cliente> C = archC.leerTodos();
        ArrayList<Prestamo> P = archP.leerTodos();

        Operaciones op = new Operaciones();

        System.out.println("a) Libros entre 80 y 120:");
        op.listarLibrosEntreXY(L, 80, 120);

        System.out.println("\nb) Ingreso total del libro 1:");
        System.out.println(op.ingresoPorLibro(P, L, 1));

        System.out.println("\nc) Libros nunca vendidos:");
        op.librosNuncaVendidos(L, P);

        System.out.println("\nd) Clientes que compraron el libro 1:");
        op.clientesQueCompraronLibro(C, P, 1);

        System.out.println("\ne) Libro más prestado:");
        System.out.println(op.libroMasPrestado(L, P));

        System.out.println("\nf) Cliente con más préstamos:");
        System.out.println(op.clienteConMasPrestamos(C, P));
    }
}
