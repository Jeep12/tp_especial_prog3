package base;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorConfigMaquinas {
    private int piezasTotales;
    private final List<Maquina> maquinas;

    public LectorConfigMaquinas() {
        this.maquinas = new ArrayList<>();
    }

    public void leerArchivo(String nombreArchivo) {
        String ruta = "src/" + nombreArchivo ;
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            // 1) número total de piezas
            String linea = br.readLine();
            if (linea != null) {
                piezasTotales = Integer.parseInt(linea.trim());
            }

            // 2) resto de líneas: cada máquina en su propia línea
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    String nombre = partes[0].trim();
                    int capacidad = Integer.parseInt(partes[1].trim());
                    maquinas.add(new Maquina(capacidad, nombre, false));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer " + ruta + ": " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Dato numérico inválido: " + e.getMessage());
        }
    }

    public int getPiezasTotales() {
        return piezasTotales;
    }

    public List<Maquina> getMaquinas() {
        return maquinas;
    }
}
