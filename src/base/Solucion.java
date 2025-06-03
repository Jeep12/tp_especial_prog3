package base;

import java.util.ArrayList;
import java.util.List;

public class Solucion {

    private List<Maquina> solucion; // o List<List<Maquina>>
    Integer puestasEnMarcha;

    public Solucion() {
        this.solucion = new ArrayList<>();
        this.puestasEnMarcha = null;
    }

    public Integer getPuestasEnMarcha() {
        return puestasEnMarcha;
    }

    public void setPuestasEnMarcha(Integer puestasEnMarcha) {
        this.puestasEnMarcha = puestasEnMarcha;
    }

    public List<Maquina>getSoluciones() {
        return solucion;
    }

    public void setSoluciones(List<Maquina> soluciones) {
        this.solucion = soluciones;
    }

    @Override
    public String toString() {
        return "Puestas en marcha necesarias: " + this.puestasEnMarcha + " \nMaquinas necesarias " + solucion.toString();
    }
}

