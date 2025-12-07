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
class ArchZoo {

    private Zoologico[] z;
    private int n;
    private String nombre;

    public ArchZoo(int tam) {
        z = new Zoologico[tam];
        n = 0;
    }

// a) crear
    public void crear(Scanner sc) {
        System.out.print("Cantidad de zoológicos: ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            z[i] = new Zoologico();
            z[i].leer(sc);
        }
    }

// a) modificar por id
    public void modificar(int id, Scanner sc) {
        for (int i = 0; i < n; i++) {
            if (z[i].getId() == id) {
                System.out.println("Modificar nombre: ");
                String nuevo = sc.next();
// no hay setter, entonces se recrea
                Zoologico aux = new Zoologico();
// lectura completa
                aux.leer(sc);
                z[i] = aux;
            }
        }
    }
// c) listar y eliminar los vacíos

    public void eliminarVacios() {
        for (int i = 0; i < n; i++) {
            if (z[i].getNroAnimales() == 0) {
                z[i].mostrar();
            }
        }

        int j = 0;
        for (int i = 0; i < n; i++) {
            if (z[i].getNroAnimales() != 0) {
                z[j] = z[i];
                j++;
            }
        }
        n = j;
    }

// d) mostrar animales de especie x
    public void mostrarEspecie(String x) {
        for (int i = 0; i < n; i++) {
            Animal[] a = z[i].getAnimales();
            for (int j = 0; j < z[i].getNroAnimales(); j++) {
                if (a[j].getEspecie().equals(x)) {
                    a[j].mostrar();
                }
            }
        }
    }

// e) mover animales de zoológico X a Y
    public void mover(int x, int y) {
        Zoologico zx = null;
        Zoologico zy = null;

        for (int i = 0; i < n; i++) {
            if (z[i].getId() == x) {
                zx = z[i];
            }
            if (z[i].getId() == y) {
                zy = z[i];
            }
        }

        if (zx != null && zy != null) {
            int nx = zx.getNroAnimales();
            int ny = zy.getNroAnimales();

            Animal[] ax = zx.getAnimales();
            Animal[] ay = zy.getAnimales();

            for (int i = 0; i < nx; i++) {
                ay[ny] = ax[i];
                ny++;
            }

            zx.setNroAnimales(0);
            zy.setNroAnimales(ny);
        }
    }

    public void mayorVariedad() {
        int max = -1;
        for (int i = 0; i < n; i++) {
            if (z[i].getNroAnimales() > max) {
                max = z[i].getNroAnimales();
            }
        }
        for (int i = 0; i < n; i++) {
            if (z[i].getNroAnimales() == max) {
                z[i].mostrar();
            }
        }
    }
}
