/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author Doghymen
 */
public class ArchiNota {

    private String nombreArchi;

    public ArchiNota(String nombreArchi) {
        this.nombreArchi = nombreArchi;
    }

    // a)
    public void crearArchivo() {
        try {
            FileOutputStream fos = new FileOutputStream(nombreArchi);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.close();
        } catch (Exception e) {
            System.out.println("Error al crear archivo: " + e.getMessage());
        }
    }

    // b)
    public void agregarVarios(Nota[] vec, int nro) {
        try {
            ArrayList<Nota> lista = leerNotas();

            int i = 0;
            while (i < nro) {
                lista.add(vec[i]);
                i = i + 1;
            }

            FileOutputStream fos = new FileOutputStream(nombreArchi);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lista);
            oos.close();

        } catch (Exception e) {
            System.out.println("Error al agregar varios: " + e.getMessage());
        }
    }

    public void agregarNota(Nota n) {
        try {
            ArrayList<Nota> lista = leerNotas();
            lista.add(n);

            FileOutputStream fos = new FileOutputStream(nombreArchi);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lista);
            oos.close();

        } catch (Exception e) {
            System.out.println("Error al agregar nota: " + e.getMessage());
        }
    }

    // c)
    public float promedioNotas() {
        try {
            ArrayList<Nota> lista = leerNotas();

            float suma = 0;
            int i = 0;

            while (i < lista.size()) {
                suma = suma + lista.get(i).getNotaFinal();
                i = i + 1;
            }

            if (lista.size() > 0) {
                return suma / lista.size();
            }

        } catch (Exception e) {
            System.out.println("Error en promedio: " + e.getMessage());
        }
        return 0;
    }

    // d)
    public ArrayList<Nota> mejoresNotas() {
        ArrayList<Nota> resultado = new ArrayList<>();

        try {
            ArrayList<Nota> lista = leerNotas();

            if (lista.size() == 0) {
                return resultado;
            }

            float mayor = lista.get(0).getNotaFinal();

            int i = 1;
            while (i < lista.size()) {
                if (lista.get(i).getNotaFinal() > mayor) {
                    mayor = lista.get(i).getNotaFinal();
                }
                i = i + 1;
            }

            int j = 0;
            while (j < lista.size()) {
                if (lista.get(j).getNotaFinal() == mayor) {
                    resultado.add(lista.get(j));
                }
                j = j + 1;
            }

        } catch (Exception e) {
            System.out.println("Error en mejoresNotas: " + e.getMessage());
        }

        return resultado;
    }

    // e)
    public void eliminarMateria(String materia) {
        try {
            ArrayList<Nota> lista = leerNotas();
            ArrayList<Nota> nuevaLista = new ArrayList<>();

            int i = 0;
            while (i < lista.size()) {
                if (!lista.get(i).getMateria().equalsIgnoreCase(materia)) {
                    nuevaLista.add(lista.get(i));
                }
                i = i + 1;
            }

            FileOutputStream fos = new FileOutputStream(nombreArchi);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(nuevaLista);
            oos.close();

        } catch (Exception e) {
            System.out.println("Error al eliminar materia: " + e.getMessage());
        }
    }

    private ArrayList<Nota> leerNotas() {
        ArrayList<Nota> lista = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(nombreArchi);
            ObjectInputStream ois = new ObjectInputStream(fis);
            lista = (ArrayList<Nota>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            // archivo vacío o inexistente → lista vacía
        }

        return lista;
    }

    void mejorNota() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
