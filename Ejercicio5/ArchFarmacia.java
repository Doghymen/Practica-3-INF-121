/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio5;

import java.io.*;

/**
 *
 * @author Doghymen
 */
public class ArchFarmacia {

    private String na;

    public ArchFarmacia(String na) {
        this.na = na;
    }

    public void crearArchivo() {
        try {
            File f = new File(na);
            if (!f.exists()) {
                f.createNewFile();
            }
        } catch (Exception e) {
            System.out.println("Error al crear archivo");
        }
    }

    public void adicionar(Farmacia fa) {
        try {
            File f = new File(na);
            FileOutputStream fos = new FileOutputStream(f, true);
            ObjectOutputStream oos;

            if (f.length() == 0) {
                oos = new ObjectOutputStream(fos);
            } else {
                oos = new MiObjectOutputStream(fos);
            }

            oos.writeObject(fa);
            oos.close();
        } catch (Exception e) {
            System.out.println("Error al adicionar");
        }
    }

    public void listar() {
        try {
            FileInputStream fis = new FileInputStream(na);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {
                Farmacia fa = (Farmacia) ois.readObject();
                fa.mostrar();
            }
        } catch (Exception e) {
        }
    }

    // -------------------- A ----------------------------
    public void mostrarMedicamentosResfrios(int x) {
        try {
            FileInputStream fis = new FileInputStream(na);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {
                Farmacia fa = (Farmacia) ois.readObject();
                if (fa.getSucursal() == x) {
                    fa.mostrarMedicamentos("Tos");
                }
            }
        } catch (Exception e) {
        }
    }

    // -------------------- B ----------------------------
    public void mostrarSucursalesTapsin() {
        try {
            FileInputStream fis = new FileInputStream(na);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {
                Farmacia fa = (Farmacia) ois.readObject();

                if (fa.buscaMedicamento("Tapsin") == 1) {
                    System.out.println("Sucursal: " + fa.getSucursal());
                    System.out.println("Dirección: " + fa.getDireccion());
                }
            }
        } catch (Exception e) {
        }
    }

    // -------------------- C ----------------------------
    public void buscarPorTipo(String tipo) {
        try {
            FileInputStream fis = new FileInputStream(na);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {
                Farmacia fa = (Farmacia) ois.readObject();
                fa.mostrarMedicamentos(tipo);
            }
        } catch (Exception e) {
        }
    }

    // -------------------- D ----------------------------
    public void ordenarPorDireccion() {
        Farmacia vec[] = new Farmacia[200];
        int n = 0;

        try {
            FileInputStream fis = new FileInputStream(na);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {
                vec[n] = (Farmacia) ois.readObject();
                n++;
            }
        } catch (Exception e) {
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (vec[i].getDireccion().compareToIgnoreCase(vec[j].getDireccion()) > 0) {
                    Farmacia aux = vec[i];
                    vec[i] = vec[j];
                    vec[j] = aux;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            vec[i].mostrar();
        }
    }

    // -------------------- E ----------------------------
    public void moverMedicamentos(String tipo, int y, int z) {
        Farmacia origen = null;
        Farmacia destino = null;

        try {
            FileInputStream fis = new FileInputStream(na);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {
                Farmacia fa = (Farmacia) ois.readObject();

                if (fa.getSucursal() == y) {
                    origen = fa;
                }
                if (fa.getSucursal() == z) {
                    destino = fa;
                }
            }
        } catch (Exception e) {
        }

        if (origen != null && destino != null) {
            int i = 0;
            while (i < origen.getNroMedicamentos()) {
                Medicamento med = origen.getMedicamento(i);

                if (med.getTipo().equalsIgnoreCase(tipo)) {
                    destino.agregarMedicamento(med);
                    origen.eliminarMedicamento(i);
                } else {
                    i++;
                }
            }
        }
    }
}

class MiObjectOutputStream extends ObjectOutputStream {

    MiObjectOutputStream(OutputStream o) throws IOException {
        super(o);
    }

    @Override
    protected void writeStreamHeader() {
    }
}
