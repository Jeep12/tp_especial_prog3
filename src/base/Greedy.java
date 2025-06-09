package base;
import base.Maquina;
import base.Solucion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Greedy {
    private List<Maquina> maquinas;
    private Integer piezasAproducir;

    public Greedy(List<Maquina> maquinas, Integer piezasAproducir) {
        this.maquinas = maquinas;
        this.piezasAproducir = 0;
        //las piezas a producir deberian invocarse en el metodo porq al principio no se dio ninguna orden
    }
    //ordeno de mayor a menor
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
    /*LA SOLUCION GREEDY CONSISTE EN QUE SI LA MAQUINA PUEDE REPETIRSE DEBE USARSE ASI MISMA HASTA Q SOLO LE QUEDEN POCOS USOS
    RECIEN AHI PASAR A LA SIGUIENTE, SI QUIERO PRODUCIR 1 PIEZA Y HAY UNA MAQUINA DE 5000 VA A AGARRAR ESA MAQUINA, AL IGUAL Q SI HAY
    10500 PIEZAS VA A AGARRAR 3 VECES LA MAQUINA CON 5000 PIEZAS DE PRODUCCION, EN LA MAYORIA DE LOS CASOS VA A DAR LA MEJOR SOLUCION
    EN OTROS VA A SER INEFICIENTE PORQ VA A USAR UNA MAQUINA CON DEMASIADA CAPACIDAD PARA PRODUCIR POCAS PIEZAS
    * */
    private void greedy(List<Maquina> candidatos, int piezasAproducir, Solucion solucion) {
       //este contador lleva las puestas en marcha
        int contador = 0;
        // mientras existan todavia candidatos y las piezas a producir sean mayor a 0 probar
        while (!candidatos.isEmpty() && piezasAproducir > 0) {
            //como las maquinas ya estan ordenadas tomo la decision greedy de ir por la primera
            //osea la que tiene mayor capacidad
            Maquina maquina = candidatos.get(0);//empiezo en la pos 0 porq estan de mayor a menor
            int capacidadMaxima =  maquina.getCantPiezasMax(); //esto me da la maquina actual
            //si la capacidad excede demasiado la capacidad de produccion de la maquina entonces
            while (capacidadMaxima <= piezasAproducir) {
                solucion.getSoluciones().add(maquina);
                contador++;
                piezasAproducir -= capacidadMaxima; //resta para saber cuantas piezas quedan por producir
            }
            candidatos.remove(0); //remuevo el primero para seguir con el siguiente primero
            }
        solucion.setPuestasEnMarcha(contador);
        }


    }
