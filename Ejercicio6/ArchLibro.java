/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio6;

import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author Doghymen
 */
public class ArchLibro {

    private String nomArch;

    public ArchLibro(String nomArch) {
        this.nomArch = nomArch;
    }

    public ArrayList<Libro> leerTodos() {
        ArrayList<Libro> lista = new ArrayList<>();
        try {
            File f = new File(nomArch);
            if (!f.exists()) {
                return lista;
            }

            BufferedReader br = new BufferedReader(new FileReader(f));
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] v = linea.split(",");
                int cod = Integer.parseInt(v[0]);
                String titulo = v[1];
                double precio = Double.parseDouble(v[2]);
                lista.add(new Libro(cod, titulo, precio));
            }

            br.close();
        } catch (Exception e) {
        }
        return lista;
    }

    void agregar(Libro libro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
