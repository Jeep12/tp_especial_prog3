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
        this.solucion = new Solucion();
        this.estadosGenerados = 0;
    }


    public Solucion secuencias() {
        Estado estado = new Estado();
        backtracking(estado);
        return this.solucion;
    }
    /*
    Explicacíon:
    En el estado llevamos los datos para ir generando estados con la cantidad de puestas en marcha, las piezas producidas y la secuencia
    Estado final: si alcanzamos a producir todas las piezas.
    En la solucion vamos llevando las puestas en marcha y cuando se encuentra una mejor actualizamos  la mejor solucion (puestas en marcha )


    */


    private boolean backtracking(Estado estado) {
        estadosGenerados++;  // cada vez que entras a backtracking, contás un estado

        //Estado final
        //Si llego a la cantidad de piezas producidas busco una mejor solucion con las puestas en marcha.
        if (estado.getPiezasProducidas().equals(piezasAProducir)) {//estado final

            //Si las puestas en marcha que lleva el estado es menor a la que llevamos en la solucion la agregamos.
            //Y actualizamos las puestas en marcha en la solucion.
            if (solucion.getPuestasEnMarcha() == null || estado.getPuestasEnMarcha() < solucion.getPuestasEnMarcha()) {
                System.out.println("\nEncontramos solucion!" + estado.getSecuencia() + " Puestas en marcha " + estado.getPuestasEnMarcha() + "\n");
                solucion.getSoluciones().clear();
                solucion.getSoluciones().addAll(new ArrayList<>(estado.getSecuencia()));
                solucion.setPuestasEnMarcha(estado.getPuestasEnMarcha());
                return false; // cortás porque ya encontraste la mejor
            }
        } else {
            for (Maquina maquina : maquinas) {
                int nuevasPiezas = estado.getPiezasProducidas() + maquina.getCantPiezasMax();
                int nuevasPuestas = estado.getPuestasEnMarcha() + 1;


                if (nuevasPiezas <= piezasAProducir &&
                        (solucion.getPuestasEnMarcha() == null || nuevasPuestas < solucion.getPuestasEnMarcha())) {


                    //pongo las piezas que produce y el nombre de la maquina en la secuencia del estado
                    estado.getSecuencia().add(maquina);


                    estado.sumarPiezasProducidas(maquina.getCantPiezasMax());
                    estado.setPuestasEnMarcha(estado.getPuestasEnMarcha() + 1);

                    System.out.println("Estado generado: " + estado.getSecuencia() + " | Piezas producidas: " + estado.getPiezasProducidas() + " | Puestas en marcha: " + estado.getPuestasEnMarcha());
                    boolean mejorSolucion = backtracking(estado);
                    if (mejorSolucion) {
                        return true;
                    }

                    estado.getSecuencia().remove(estado.getSecuencia().size() - 1);

                    estado.restarPiezasProducidas(maquina.getCantPiezasMax());
                    estado.setPuestasEnMarcha(estado.getPuestasEnMarcha() - 1);
                }
            }

        }
        return false;

    }



    private void backtracking2(Estado estado) {
        estadosGenerados++;  // cada vez que entras a backtracking, contás un estado

        //Estado final
        //Si llego a la cantidad de piezas producidas busco una mejor solucion con las puestas en marcha.
        if (estado.getPiezasProducidas().equals(piezasAProducir)) {//estado final

            //Si las puestas en marcha que lleva el estado es menor a la que llevamos en la solucion la agregamos.
            //Y actualizamos las puestas en marcha en la solucion.
            if (solucion.getPuestasEnMarcha() == null || estado.getPuestasEnMarcha() < solucion.getPuestasEnMarcha()) {
                System.out.println("\nEncontramos solucion!" + estado.getSecuencia() + " Puestas en marcha " + estado.getPuestasEnMarcha() + "\n");
                solucion.getSoluciones().clear();
                solucion.getSoluciones().addAll(new ArrayList<>(estado.getSecuencia()));
                solucion.setPuestasEnMarcha(estado.getPuestasEnMarcha());

            }
        } else {
            for (Maquina maquina : maquinas) {
                int nuevasPiezas = estado.getPiezasProducidas() + maquina.getCantPiezasMax();
                int nuevasPuestas = estado.getPuestasEnMarcha() + 1;


                if (nuevasPiezas <= piezasAProducir &&
                        (solucion.getPuestasEnMarcha() == null || nuevasPuestas < solucion.getPuestasEnMarcha())) {


                    //pongo las piezas que produce y el nombre de la maquina en la secuencia del estado
                    estado.getSecuencia().add(maquina);


                    estado.sumarPiezasProducidas(maquina.getCantPiezasMax());
                    estado.setPuestasEnMarcha(estado.getPuestasEnMarcha() + 1);

                    System.out.println("Estado generado: " + estado.getSecuencia() + " | Piezas producidas: " + estado.getPiezasProducidas() + " | Puestas en marcha: " + estado.getPuestasEnMarcha());
                   backtracking2(estado);


                    estado.getSecuencia().remove(estado.getSecuencia().size() - 1);

                    estado.restarPiezasProducidas(maquina.getCantPiezasMax());
                    estado.setPuestasEnMarcha(estado.getPuestasEnMarcha() - 1);
                }
            }

        }

    }


    public long getEstadosGenerados() {
        return estadosGenerados;
    }

}

