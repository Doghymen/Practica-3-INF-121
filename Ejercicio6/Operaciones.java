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
public class Operaciones {
    // a)
    public void listarLibrosEntreXY(ArrayList<Libro> L, double x, double y) {
        int i = 0;
        while (i < L.size()) {
            double precio = L.get(i).getPrecio();
            if (precio >= x && precio <= y) {
                System.out.println(L.get(i));
            }
            i = i + 1;
        }
    }

    // b)
    public double ingresoPorLibro(ArrayList<Prestamo> P, ArrayList<Libro> L, int codLibro) {
        double precio = 0;

        int i = 0;
        while (i < L.size()) {
            if (L.get(i).getCodLibro() == codLibro) {
                precio = L.get(i).getPrecio();
            }
            i = i + 1;
        }

        int total = 0;

        int j = 0;
        while (j < P.size()) {
            if (P.get(j).getCodLibro() == codLibro) {
                total = total + P.get(j).getCantidad();
            }
            j = j + 1;
        }

        return total * precio;
    }

    // c)
    public void librosNuncaVendidos(ArrayList<Libro> L, ArrayList<Prestamo> P) {
        int i = 0;
        while (i < L.size()) {
            int cod = L.get(i).getCodLibro();

            boolean vendido = false;

            int j = 0;
            while (j < P.size()) {
                if (P.get(j).getCodLibro() == cod) {
                    vendido = true;
                }
                j = j + 1;
            }

            if (vendido == false) {
                System.out.println(L.get(i));
            }

            i = i + 1;
        }
    }

    // d) 
    public void clientesQueCompraronLibro(ArrayList<Cliente> C, ArrayList<Prestamo> P, int codLibro) {

        int j = 0;
        while (j < P.size()) {
            if (P.get(j).getCodLibro() == codLibro) {

                int codCliente = P.get(j).getCodCliente();

                int i = 0;
                while (i < C.size()) {
                    if (C.get(i).getCodCliente() == codCliente) {
                        System.out.println(C.get(i));
                    }
                    i = i + 1;
                }
            }
            j = j + 1;
        }
    }

    // e) 
    public int libroMasPrestado(ArrayList<Libro> L, ArrayList<Prestamo> P) {

        int max = -1;
        int mejor = -1;

        int i = 0;
        while (i < L.size()) {
            int cod = L.get(i).getCodLibro();
            int total = 0;

            int j = 0;
            while (j < P.size()) {
                if (P.get(j).getCodLibro() == cod) {
                    total = total + P.get(j).getCantidad();
                }
                j = j + 1;
            }

            if (total > max) {
                max = total;
                mejor = cod;
            }

            i = i + 1;
        }

        return mejor;
    }

    // f)
    public int clienteConMasPrestamos(ArrayList<Cliente> C, ArrayList<Prestamo> P) {

        int mejor = -1;
        int max = -1;

        int i = 0;
        while (i < C.size()) {
            int cod = C.get(i).getCodCliente();
            int total = 0;

            int j = 0;
            while (j < P.size()) {
                if (P.get(j).getCodCliente() == cod) {
                    total = total + P.get(j).getCantidad();
                }
                j = j + 1;
            }

            if (total > max) {
                max = total;
                mejor = cod;
            }

            i = i + 1;
        }

        return mejor;
    }
}
