/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Doghymen
 */
public class ArchivoTrabajador {

    private String nombreArch;

    public ArchivoTrabajador() {
        nombreArch = "trabajadores.dat";
    }

    // a)
    public void crearArchivo() {
        try {
            FileOutputStream fos = new FileOutputStream(nombreArch);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("Error al crear archivo: " + e.getMessage());
        }
    }

   
    private ArrayList<Trabajador> leerTrabajadores() {
        ArrayList<Trabajador> lista = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(nombreArch);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {
                Trabajador t = (Trabajador) ois.readObject();
                lista.add(t);
            }

        } catch (EOFException e) {
        } catch (Exception e) {
        }

        return lista;
    }

    private void escribirTrabajadores(ArrayList<Trabajador> lista) {
        try {
            FileOutputStream fos = new FileOutputStream(nombreArch);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (int i = 0; i < lista.size(); i++) {
                oos.writeObject(lista.get(i));
            }

            oos.close();
            fos.close();

        } catch (IOException e) {
            System.out.println("Error al escribir archivo.");
        }
    }

    // b)
    public void guardarTrabajador(Trabajador t) {
        ArrayList<Trabajador> lista = leerTrabajadores();
        lista.add(t);
        escribirTrabajadores(lista);
    }

    // c)
    public void aumentaSalario(int a, Trabajador t) {
        ArrayList<Trabajador> lista = leerTrabajadores();

        for (int i = 0; i < lista.size(); i++) {
            Trabajador aux = lista.get(i);

            if (aux.getCarnet() == t.getCarnet()) {
                double nuevo = aux.getSalario() + a;
                aux.setSalario(nuevo);
            }
        }

        escribirTrabajadores(lista);
    }

    // d)
    public Trabajador mayorSalario() {
        ArrayList<Trabajador> lista = leerTrabajadores();

        if (lista.size() == 0) {
            return null;
        }

        Trabajador mayor = lista.get(0);

        for (int i = 1; i < lista.size(); i++) {
            if (lista.get(i).getSalario() > mayor.getSalario()) {
                mayor = lista.get(i);
            }
        }

        return mayor;
    }

    // e)
    public void ordenarPorSalario() {
        ArrayList<Trabajador> lista = leerTrabajadores();

        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = i + 1; j < lista.size(); j++) {
                if (lista.get(i).getSalario() > lista.get(j).getSalario()) {

                    Trabajador aux = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, aux);
                }
            }
        }

        escribirTrabajadores(lista);
    }
}
