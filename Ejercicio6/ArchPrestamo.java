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
public class ArchPrestamo {

    private String nomArch;

    public ArchPrestamo(String nomArch) {
        this.nomArch = nomArch;
    }

    public ArrayList<Prestamo> leerTodos() {
        ArrayList<Prestamo> lista = new ArrayList<>();
        try {
            File f = new File(nomArch);
            if (!f.exists()) {
                return lista;
            }

            BufferedReader br = new BufferedReader(new FileReader(f));
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] v = linea.split(",");
                int ccli = Integer.parseInt(v[0]);
                int clib = Integer.parseInt(v[1]);
                String fecha = v[2];
                int cant = Integer.parseInt(v[3]);
                lista.add(new Prestamo(ccli, clib, fecha, cant));
            }

            br.close();
        } catch (Exception e) {
        }
        return lista;
    }

    void agregar(Prestamo prestamo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
