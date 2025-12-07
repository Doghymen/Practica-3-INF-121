/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author Doghymen
 */
public class ArchEmpresa {

    private String nombreArchivo;

    public ArchEmpresa(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void adicionarEmpresa(Empresa emp) {
        try {
            FileWriter fw = new FileWriter(nombreArchivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(emp.toString());
            bw.newLine();
            bw.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void mostrarEmpresas() {
        try {
            FileReader fr = new FileReader(nombreArchivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            linea = br.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void buscarEmpresa(String nombreBuscado) {
        try {
            FileReader fr = new FileReader(nombreArchivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            linea = br.readLine();
            boolean encontrado = false;
            while (linea != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    if (partes[0].equalsIgnoreCase(nombreBuscado)) {
                        System.out.println("Empresa encontrada: " + linea);
                        encontrado = true;
                    }
                }
                linea = br.readLine();
            }
            br.close();

            if (!encontrado) {
                System.out.println("No se encontró la empresa.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
