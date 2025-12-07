/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.*;
/**
 *
 * @author Doghymen
 */


public class Principal {

    private static final String NOMBRE_ARCHIVO = "charangos.json";

    public static void main(String[] args) {
        boolean[] cu1 = {true,true,false,true,false,true,true,false,true,true};
        boolean[] cu2 = {false,false,false,false,false,false,false,true,true,true};
        boolean[] cu3 = {true,true,true,true,true,true,true,true,true,true};

        List<Charango> lista = new ArrayList<Charango>();
        lista.add(new Charango("Madera", 10, cu1));
        lista.add(new Charango("Plastico", 10, cu2));
        lista.add(new Charango("Metal", 10, cu3));
        lista.add(new Charango("Madera", 9, cu1));

        guardarEnArchivo(lista);

        List<Charango> leidos = leerDesdeArchivo();

        // b)
        List<Charango> despuesB = eliminarConMasDe6False(leidos);

        // c)
        List<Charango> listaMaterial = listarPorMaterial(leidos, "Madera");

        // d)
        List<Charango> conDiez = buscarCon10Cuerdas(leidos);

        // e)
        ordenarPorMaterial(leidos);

        System.out.println("Lista leida:");
        for (int i = 0; i < leidos.size(); i++) {
            System.out.println(leidos.get(i));
        }

        System.out.println("\nDespués de eliminar (inciso b):");
        for (int i = 0; i < despuesB.size(); i++) {
            System.out.println(despuesB.get(i));
        }

        System.out.println("\nListado por material = Madera (inciso c):");
        for (int i = 0; i < listaMaterial.size(); i++) {
            System.out.println(listaMaterial.get(i));
        }

        System.out.println("\nCharangos con 10 cuerdas (inciso d):");
        for (int i = 0; i < conDiez.size(); i++) {
            System.out.println(conDiez.get(i));
        }

        System.out.println("\nOrdenados por material (inciso e):");
        for (int i = 0; i < leidos.size(); i++) {
            System.out.println(leidos.get(i));
        }
    }


    public static void guardarEnArchivo(List<Charango> lista) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(NOMBRE_ARCHIVO));
            pw.println("[");
            for (int i = 0; i < lista.size(); i++) {
                Charango c = lista.get(i);
                pw.print("  {");
                pw.print("\"material\":\"" + escapar(c.getMaterial()) + "\",");
                pw.print("\"nroCuerdas\":" + c.getNroCuerdas() + ",");
                pw.print("\"cuerdas\":[");
                boolean[] cuerdas = c.getCuerdas();
                for (int j = 0; j < cuerdas.length; j++) {
                    pw.print(cuerdas[j]);
                    if (j < cuerdas.length - 1) pw.print(",");
                }
                pw.print("]}");
                if (i < lista.size() - 1) pw.print(",");
                pw.println();
            }
            pw.println("]");
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        } finally {
            if (pw != null) pw.close();
        }
    }

    public static List<Charango> leerDesdeArchivo() {
        List<Charango> lista = new ArrayList<Charango>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(NOMBRE_ARCHIVO));
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.startsWith("{")) {

                    String lineaMaterial = br.readLine();
                    if (lineaMaterial == null) break;
                    lineaMaterial = lineaMaterial.trim();
                    String material = parseValorString(lineaMaterial);

                    String lineaNro = br.readLine();
                    if (lineaNro == null) break;
                    lineaNro = lineaNro.trim();
                    int nro = parseValorInt(lineaNro);

                    String lineaCuerdas = br.readLine();
                    if (lineaCuerdas == null) break;
                    lineaCuerdas = lineaCuerdas.trim();
                    boolean[] cuerdas = parseCuerdas(lineaCuerdas);

                    br.readLine();

                    Charango c = new Charango(material, nro, cuerdas);
                    lista.add(c);
                }
            }
        } catch (FileNotFoundException e) {
            return lista;
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return lista;
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
            }
        }
        return lista;
    }

    private static String escapar(String s) {
        if (s == null) return "";
        return s.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    private static String parseValorString(String linea) {
        int idx = linea.indexOf(":");
        String derecho = linea.substring(idx + 1).trim();
        if (derecho.endsWith(",")) derecho = derecho.substring(0, derecho.length() - 1).trim();
        if (derecho.startsWith("\"") && derecho.endsWith("\"")) {
            derecho = derecho.substring(1, derecho.length() - 1);
        }
        derecho = derecho.replace("\\\"", "\"").replace("\\\\", "\\");
        return derecho;
    }

    private static int parseValorInt(String linea) {
        int idx = linea.indexOf(":");
        String derecho = linea.substring(idx + 1).trim();
        if (derecho.endsWith(",")) derecho = derecho.substring(0, derecho.length() - 1).trim();
        return Integer.parseInt(derecho);
    }

    private static boolean[] parseCuerdas(String linea) {
        int ini = linea.indexOf("[");
        int fin = linea.indexOf("]");
        String dentro = linea.substring(ini + 1, fin).trim();
        String[] partes = new String[0];
        if (!dentro.isEmpty()) {
            partes = dentro.split(",");
        }
        boolean[] cuerdas = new boolean[10];
        for (int i = 0; i < 10; i++) {
            if (i < partes.length) {
                String p = partes[i].trim();
                cuerdas[i] = Boolean.parseBoolean(p);
            } else {
                cuerdas[i] = false;
            }
        }
        return cuerdas;
    }

    // ---------- b) ----------
    public static List<Charango> eliminarConMasDe6False(List<Charango> lista) {
        List<Charango> resultado = new ArrayList<Charango>();
        for (int i = 0; i < lista.size(); i++) {
            Charango c = lista.get(i);
            int contadorFalse = 0;
            boolean[] cuerdas = c.getCuerdas();
            for (int j = 0; j < cuerdas.length; j++) {
                if (!cuerdas[j]) {
                    contadorFalse++;
                }
            }
            if (contadorFalse <= 6) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    // ---------- c) ----------
    public static List<Charango> listarPorMaterial(List<Charango> lista, String materialBuscado) {
        List<Charango> resultado = new ArrayList<Charango>();
        for (int i = 0; i < lista.size(); i++) {
            Charango c = lista.get(i);
            if (c.getMaterial() != null && c.getMaterial().equalsIgnoreCase(materialBuscado)) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    // ---------- d) ----------
    public static List<Charango> buscarCon10Cuerdas(List<Charango> lista) {
        List<Charango> resultado = new ArrayList<Charango>();
        for (int i = 0; i < lista.size(); i++) {
            Charango c = lista.get(i);
            if (c.getNroCuerdas() == 10) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    // ---------- e) ----------
    public static void ordenarPorMaterial(List<Charango> lista) {
        int n = lista.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                Charango a = lista.get(j);
                Charango b = lista.get(j + 1);
                String ma = (a.getMaterial() == null) ? "" : a.getMaterial();
                String mb = (b.getMaterial() == null) ? "" : b.getMaterial();
                if (ma.compareToIgnoreCase(mb) > 0) {
                    lista.set(j, b);
                    lista.set(j + 1, a);
                }
            }
        }
    }
}
