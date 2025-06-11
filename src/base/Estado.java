package base;

import java.util.ArrayList;
import java.util.List;

public class Estado {

    Integer piezasProducidas;
    List<Maquina> secuencia = new ArrayList<>();
    Integer puestasEnMarcha;

    public Estado() {
        this.secuencia = new ArrayList<>();
        this.puestasEnMarcha = 0;  // arranca en cero acá
        this.piezasProducidas = 0;
    }

    public Integer getPiezasProducidas() {
        return piezasProducidas;
    }

    public Integer getPuestasEnMarcha() {
        return puestasEnMarcha;
    }

    public void setPuestasEnMarcha(Integer puestasEnMarcha) {
        this.puestasEnMarcha = puestasEnMarcha;
    }

    public List<Maquina> getSecuencia() {
        return secuencia;
    }

    public void sumarPiezasProducidas(Integer elem) {
        this.piezasProducidas += elem;
    }

    public void restarPiezasProducidas(Integer elem) {
        this.piezasProducidas -= elem;
    }
}
