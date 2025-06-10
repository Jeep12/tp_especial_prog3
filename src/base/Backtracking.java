package base;

import java.util.ArrayList;
import java.util.List;

public class Backtracking {

    Integer piezasAProducir;
    List<Maquina> maquinas;
    long estadosGenerados;  // contador

    Solucion solucion;

    public Backtracking(List<Maquina> maquinas, Integer piezasAProducir) {
        this.maquinas = maquinas;
        this.piezasAProducir = piezasAProducir;
        this.solucion = null;
        this.estadosGenerados = 0;
    }

    public Solucion secuencias() {
        Estado estado = new Estado();
        backtracking(estado);
        return this.solucion;
    }

        /*
    Explicación:
    En el estado vamos guardando las piezas producidas, las puestas en marcha y la secuencia de máquinas usada.

    Estado final: cuando llegamos justo a la cantidad de piezas a producir.
    Si en ese punto usamos menos puestas en marcha que la mejor solución guardada, actualizamos la solución.

    Poda: evitamos generar un estado nuevo si:
    - ya nos pasamos con las piezas
    - o si el nuevo estado tiene más puestas en marcha que la mejor solución hasta ahora

    Así evitamos recorrer caminos que no sirven.
    */


    private void backtracking(Estado estado) {
        estadosGenerados++;

        //poda si se paso de piezas producidas
        if (estado.getPiezasProducidas() > piezasAProducir) {
            return;
        }

        //estado final llegamos a la cantidad de piezas que queremos producir
        if (estado.getPiezasProducidas().equals(piezasAProducir)) {//Estado final

            //Mejor solucion
            //si las puestas en marcha es menor a las que llevamos en la solucion o solucion == null para que entre la primera vez.
            //agregamos actualizamos la mejor solucion o la creamos
            if (solucion == null || estado.getPuestasEnMarcha() < solucion.getPuestasEnMarcha()) {
                //Si no hay una solucion creamos una ya
                if (solucion == null) {
                    solucion = new Solucion();
                }
                //Sino vamos llevando la mejor en la clase solucion con las pustas en marchas
                solucion.getSoluciones().clear();
                solucion.getSoluciones().addAll(new ArrayList<>(estado.getSecuencia()));
                solucion.setPuestasEnMarcha(estado.getPuestasEnMarcha());
            }
            return;

        }

        //Generacion hijos
        for (Maquina maquina : maquinas) {
            estado.getSecuencia().add(maquina);
            estado.sumarPiezasProducidas(maquina.getCantPiezasMax());
            estado.setPuestasEnMarcha(estado.getPuestasEnMarcha() + 1);

            System.out.println("Estado generado: " + estado.getSecuencia()
                    + " | Piezas: " + estado.getPiezasProducidas()
                    + " | Puestas: " + estado.getPuestasEnMarcha());

            backtracking(estado);

            estado.getSecuencia().remove(estado.getSecuencia().size() - 1);
            estado.restarPiezasProducidas(maquina.getCantPiezasMax());
            estado.setPuestasEnMarcha(estado.getPuestasEnMarcha() - 1);
        }


    }


    public long getEstadosGenerados() {
        return estadosGenerados;
    }
}
