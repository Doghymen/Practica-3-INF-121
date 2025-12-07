/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

/**
 *
 * @author Doghymen
 */
public class Charango {

    private String material;
    private int nroCuerdas;
    private boolean[] cuerdas; // tamaño 10

    public Charango(String material, int nroCuerdas, boolean[] cuerdas) {
        if (cuerdas == null || cuerdas.length != 10) {
            throw new IllegalArgumentException("El arreglo cuerdas debe tener exactamente 10 elementos.");
        }
        this.material = material;
        this.nroCuerdas = nroCuerdas;
        this.cuerdas = cuerdas;
    }

    public String getMaterial() {
        return material;
    }

    public int getNroCuerdas() {
        return nroCuerdas;
    }

    public boolean[] getCuerdas() {
        return cuerdas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Charango{material=");
        sb.append(material);
        sb.append(", nroCuerdas=");
        sb.append(nroCuerdas);
        sb.append(", cuerdas=[");
        for (int i = 0; i < cuerdas.length; i++) {
            sb.append(cuerdas[i] ? "true" : "false");
            if (i < cuerdas.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]}");
        return sb.toString();
    }
}
