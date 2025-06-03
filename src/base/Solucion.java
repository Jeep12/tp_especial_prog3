package base;

import java.util.ArrayList;
import java.util.List;

public class Solucion {

    private List<List<String>> soluciones; // o List<List<Maquina>>
    Integer puestasEnMarcha;

    public Solucion() {
        this.soluciones = new ArrayList<>();
        this.puestasEnMarcha = null;
    }

    public Integer getPuestasEnMarcha() {
        return puestasEnMarcha;
    }

    public void setPuestasEnMarcha(Integer puestasEnMarcha) {
        this.puestasEnMarcha = puestasEnMarcha;
    }

    public List<List<String>> getSoluciones() {
        return soluciones;
    }

    public void setSoluciones(List<List<String>> soluciones) {
        this.soluciones = soluciones;
    }

    @Override
    public String toString() {
        return "Puestas en marcha necesarias: " + this.puestasEnMarcha + " \nMaquinas necesarias " + soluciones.toString();
    }
}

