package base;
//PROBAR PONIENDO LA CONFIG DE MAQUINA DE 5000 A 5 Y VER Q PASA CON VALORES MENORES
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
public class Greedy {
    //entonces aca?
    private List<Maquina> maquinas;
    private Integer piezasAproducir;

    public Greedy(List<Maquina> maquinas, Integer piezasAproducir) {
        this.maquinas = maquinas;
        this.piezasAproducir = 0;
        //las piezas a producir deberian invocarse en el metodo porq al principio no se dio ninguna orden
    }

    public List<Maquina> ordenarMaquinas() {
        ArrayList<Maquina> arr = new ArrayList<Maquina>(maquinas);
        Collections.sort(arr);
        return arr;
    }

    public Solucion fabricaGreedy(List<Maquina> maquinas, int piezasAproducir) {
        List<Maquina> candidatos = ordenarMaquinas();//ordeno la lista para aplicar greedy de manera eficiente
        this.piezasAproducir = piezasAproducir;
        Solucion solucion=new Solucion();
        greedy(candidatos,piezasAproducir,solucion);
        return solucion;
    }

    private void greedy(List<Maquina> candidatos, int piezasAproducir, Solucion solucion) {
        // mientras existan todavia candidatos y las piezas a producir sean mayor a 0 probar
        int contador = 0;
        while (!candidatos.isEmpty() && piezasAproducir > 0) {
            //como las maquinas ya estan ordenadas tomo la decision greedy de ir por la primera
            //osea la que tiene mayor capacidad
            Maquina maquina = candidatos.get(0);
            int capacidadMaxima =  maquina.getCantPiezasMax();
            while(piezasAproducir<=capacidadMaxima && piezasAproducir>0){
                solucion.getSoluciones().add(maquina);
                contador++;
                piezasAproducir-=capacidadMaxima;
            }
            candidatos.remove(0);
        }

        if (piezasAproducir <= 0) {
            //si ya se produjeron las piezas entonces seteo las puestas en marcha y agrego la solucion
            solucion.setPuestasEnMarcha(contador);
        } else {
            //no se encontro solucion desde greedy
            solucion.setPuestasEnMarcha(null);
        }
    }
}