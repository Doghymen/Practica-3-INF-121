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
public class ArchCliente {

    private String nomArch;

    public ArchCliente(String nomArch) {
        this.nomArch = nomArch;
    }

    public ArrayList<Cliente> leerTodos() {
        ArrayList<Cliente> lista = new ArrayList<>();
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
                int ci = Integer.parseInt(v[1]);
                String nombre = v[2];
                String apellido = v[3];
                lista.add(new Cliente(cod, nombre, apellido, "Perez"));
            }

            br.close();
        } catch (Exception e) {
        }
        return lista;
    }

    void agregar(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
