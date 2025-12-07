/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

/**
 *
 * @author Doghymen
 */
public class Principal {
    public static void main(String[] args) {

        ArchivoProducto arch = new ArchivoProducto("productos.dat");

        // a)
        arch.crearArchivo();

        // b)
        Producto p1 = new Producto(1, "Leche", 7.5f);
        Producto p2 = new Producto(2, "Pan", 3.0f);
        Producto p3 = new Producto(3, "Queso", 15.0f);

        arch.guardaProducto(p1);
        arch.guardaProducto(p2);
        arch.guardaProducto(p3);

        // c)
        Producto buscado = arch.buscaProducto(2);
        System.out.println("Producto encontrado:");
        System.out.println(buscado);

        // d)
        float prom = arch.promedioPrecios();
        System.out.println("Promedio de precios: " + prom);

        // e)
        Producto mayor = arch.productoMasCaro();
        System.out.println("Producto más caro:");
        System.out.println(mayor);
    }
}
