package base;

public class Maquina implements Comparable<Maquina> {


    private String nombre;

    private Integer cantPiezasMax; // un nombre mejor no seria capacidadMaxima? es obvio q son piezas

    private Boolean encendida;

    public Maquina(Integer cantPiezasMax, String nombre) {
        this.cantPiezasMax = cantPiezasMax;
        this.nombre = nombre;
    }

    public Maquina(Integer cantPiezasMax, String nombre, Boolean encendida) {
        this(cantPiezasMax, nombre);
        this.encendida = encendida;
    }

    public Boolean getPrendida() {
        return encendida;
    }

    public void setPrendida(Boolean prendida) {
        this.encendida = prendida;
    }

    public Integer getCantPiezasMax() {
        return cantPiezasMax;
    }

    public void setCantPiezasMax(Integer cantPiezasMax) {
        this.cantPiezasMax = cantPiezasMax;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "{" +
                "" + nombre + " " +
                "" + cantPiezasMax +
                '}';
    }
    @Override
    public int compareTo(Maquina o) {
        //ordeno de mayor capacidad de piezas, a menor capacidad
        return o.cantPiezasMax-this.cantPiezasMax;
    }
}
