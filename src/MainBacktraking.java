import base.Backtracking;
import base.LectorConfigMaquinas;
import base.Maquina;

import java.util.Scanner;

public class MainBacktraking {
    public static void main(String[] args) {
        LectorConfigMaquinas lector = new LectorConfigMaquinas();
        lector.leerArchivo("config_maquinas");

        System.out.println("Maquinas disponibles");
        for (Maquina m : lector.getMaquinas()) {
            System.out.println("Maquina: " + m.getNombre() + ", Puede hacer: " + m.getCantPiezasMax());
        }


            System.out.println("\nSolucion");

            Backtracking bt = new Backtracking(lector.getMaquinas(), lector.getPiezasTotales());

            long inicio = System.nanoTime();
            System.out.println(bt.secuencias());
            long fin = System.nanoTime();

            System.out.println("Piezas preestablecidas a fabricar: " + lector.getPiezasTotales());
            System.out.println("Estados generados: "+ bt.getEstadosGenerados());
            System.out.println("Tiempo de ejecución: " + (fin - inicio) / 1_000_000.0 + " ms");

    }
}
