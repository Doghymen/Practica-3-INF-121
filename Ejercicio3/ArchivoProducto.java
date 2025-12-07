/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author Doghymen
 */
public class ArchivoProducto {
    private String nomA;

    public ArchivoProducto(String n) {
        nomA = n;
    }

    public void crearArchivo() {
        try {
            FileOutputStream fos = new FileOutputStream(nomA);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.close();
        } catch (Exception e) {
            System.out.println("Error al crear archivo: " + e.getMessage());
        }
    }

    public void guardaProducto(Producto p) {
        try {
            ArrayList<Producto> lista = leerProductos();

            lista.add(p);

            FileOutputStream fos = new FileOutputStream(nomA);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lista);
            oos.close();

        } catch (Exception e) {
            System.out.println("Error al guardar producto: " + e.getMessage());
        }
    }

    public Producto buscaProducto(int c) {
        try {
            ArrayList<Producto> lista = leerProductos();
            
            int i = 0;
            while (i < lista.size()) {
                Producto p = lista.get(i);
                if (p.getCodigo() == c) {
                    return p;
                }
                i = i + 1;
            }

        } catch (Exception e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }
        return null;
    }

    // d) PROMEDIO
    public float promedioPrecios() {
        float suma = 0;
        int i = 0;
        try {
            ArrayList<Producto> lista = leerProductos();

            while (i < lista.size()) {
                suma = suma + lista.get(i).getPrecio();
                i = i + 1;
            }

            if (lista.size() > 0)
                return suma / lista.size();

        } catch (Exception e) {
            System.out.println("Error al calcular promedio: " + e.getMessage());
        }
        return 0;
    }

    public Producto productoMasCaro() {
        try {
            ArrayList<Producto> lista = leerProductos();

            if (lista.size() == 0)
                return null;

            Producto mayor = lista.get(0);
            int i = 1;

            while (i < lista.size()) {
                if (lista.get(i).getPrecio() > mayor.getPrecio()) {
                    mayor = lista.get(i);
                }
                i = i + 1;
            }

            return mayor;

        } catch (Exception e) {
            System.out.println("Error al buscar mayor: " + e.getMessage());
        }
        return null;
    }

    private ArrayList<Producto> leerProductos() {
        ArrayList<Producto> lista = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(nomA);
            ObjectInputStream ois = new ObjectInputStream(fis);

            lista = (ArrayList<Producto>) ois.readObject();
            ois.close();

        } catch (Exception e) {
        }

        return lista;
    }
}
