/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio5;

/**
 *
 * @author Doghymen
 */
public class Principal {

    public static void main(String[] args) {

        ArchFarmacia arch = new ArchFarmacia("farmacias.dat");
        arch.crearArchivo();

        Farmacia f1 = new Farmacia();
        Farmacia f2 = new Farmacia();
        Farmacia f3 = new Farmacia();

        System.out.println("Registrar Farmacia 1:");
        f1.leer();

        System.out.println("Registrar Farmacia 2:");
        f2.leer();

        System.out.println("Registrar Farmacia 3:");
        f3.leer();

        arch.adicionar(f1);
        arch.adicionar(f2);
        arch.adicionar(f3);

        System.out.println("Mostrar medicamentos para la tos de sucursal X");
        arch.mostrarMedicamentosResfrios(2);

        System.out.println("Mostrar sucursales que tienen Tapsin:");
        arch.mostrarSucursalesTapsin();

        System.out.println("Buscar medicamentos por tipo (Ingrese tipo):");
        arch.buscarPorTipo("Analgesico");

        System.out.println("Ordenando farmacias por dirección:");
        arch.ordenarPorDireccion();

        System.out.println("Moviendo medicamentos:");
        arch.moverMedicamentos("Tos", 1, 3);

        System.out.println("LISTAR DESPUÉS DE MOVER:");
        arch.listar();
    }
}
