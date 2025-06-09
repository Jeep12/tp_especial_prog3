import base.Greedy;
import base.LectorConfigMaquinas;
import base.Maquina;
import base.Solucion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * greedy:
 * la idea es agarrar la maquina q mas piezas haga sin pasarse de lo q falta
 * osea mientras me falten piezas voy eligiendo la mejor q entre justo o lo mas cerca
 * si ninguna sirve corto ahi nomas
 * lo q quiero es usar la menor cant de maquinas posible
 * y para medir el costo cuento cuantas veces mire una maquina pa ver si me servia
 */
public class MainGreedy {
    public static void main(String[] args) {
        // leo el archivo con las maquinas y las piezas a producir
        LectorConfigMaquinas lector = new LectorConfigMaquinas();
        lector.leerArchivo("config_maquinas");

        System.out.println("maquinas disponibles:");
        for (Maquina m : lector.getMaquinas()) {
            System.out.println("maquina: " + m.getNombre() + ", produce: " + m.getCantPiezasMax());
        }

        System.out.println("\nsolucion greedy:");

        Greedy greedy = new Greedy(lector.getMaquinas(), 0); // piezas a producir se setea despues
        long inicio = System.nanoTime();
        Solucion solucion = greedy.fabricaGreedy(lector.getMaquinas(), lector.getPiezasTotales());
        long fin = System.nanoTime();

        System.out.println(solucion);
        System.out.println("piezas a producir: " + lector.getPiezasTotales());
        System.out.println("tiempo ejecucion: " + (fin - inicio) / 1_000_000.0 + " ms");
    }
}

