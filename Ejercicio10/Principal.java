/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio10;

import java.util.Scanner;

/**
 *
 * @author Doghymen
 */
public class Principal {

    public static void main(String[] args) {
        ArchEmpresa archivo = new ArchEmpresa("empresas.txt");
        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        while (opcion != 4) {
            System.out.println("1. Adicionar Empresa");
            System.out.println("2. Mostrar Empresas");
            System.out.println("3. Buscar Empresa");
            System.out.println("4. Salir");
            System.out.print("Seleccione: ");
            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {
                System.out.print("Nombre: ");
                String n = sc.nextLine();
                System.out.print("Rubro: ");
                String r = sc.nextLine();
                System.out.print("Número de empleados: ");
                int e = sc.nextInt();
                sc.nextLine();
                Empresa emp = new Empresa(n, r, e);
                archivo.adicionarEmpresa(emp);
            }

            if (opcion == 2) {
                archivo.mostrarEmpresas();
            }

            if (opcion == 3) {
                System.out.print("Nombre de empresa a buscar: ");
                String n = sc.nextLine();
                archivo.buscarEmpresa(n);
            }
        }

        sc.close();
    }
}
