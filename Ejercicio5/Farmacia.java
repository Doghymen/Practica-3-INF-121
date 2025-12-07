/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio5;

import java.util.Scanner;

/**
 *
 * @author Doghymen
 */
public class Farmacia {

    private String nombreFarmacia;
    private int sucursal;
    private String direccion;
    private int nroMedicamentos;
    private Medicamento m[] = new Medicamento[100];

    public Farmacia() {
    }

    public void leer() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre farmacia: ");
        nombreFarmacia = sc.next();

        System.out.print("Sucursal: ");
        sucursal = sc.nextInt();

        System.out.print("Dirección: ");
        direccion = sc.next();

        System.out.print("Número de medicamentos: ");
        nroMedicamentos = sc.nextInt();

        for (int i = 0; i < nroMedicamentos; i++) {
            System.out.println("Medicamento " + (i + 1));
            m[i] = new Medicamento();
            m[i].leer();
        }
    }

    public void mostrar() {
        System.out.println("Farmacia: " + nombreFarmacia);
        System.out.println("Sucursal: " + sucursal);
        System.out.println("Dirección: " + direccion);
        for (int i = 0; i < nroMedicamentos; i++) {
            m[i].mostrar();
            System.out.println("-------------------");
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void mostrarMedicamentos(String x) {
        for (int i = 0; i < nroMedicamentos; i++) {
            if (m[i].getTipo().equalsIgnoreCase(x)) {
                m[i].mostrar();
            }
        }
    }

    public int buscaMedicamento(String x) {
        for (int i = 0; i < nroMedicamentos; i++) {
            if (m[i].getNombre().equalsIgnoreCase(x)) {
                return 1;
            }
        }
        return 0;
    }

    public Medicamento getMedicamento(int i) {
        return m[i];
    }

    public int getNroMedicamentos() {
        return nroMedicamentos;
    }

    public void eliminarMedicamento(int pos) {
        for (int i = pos; i < nroMedicamentos - 1; i++) {
            m[i] = m[i + 1];
        }
        nroMedicamentos--;
    }

    public void agregarMedicamento(Medicamento x) {
        m[nroMedicamentos] = x;
        nroMedicamentos++;
    }
}
