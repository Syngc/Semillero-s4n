package co.com.s4n.semillero.ejercicio.dominio.entidades;

import co.com.s4n.semillero.ejercicio.dominio.vo.Cardinalidad;

public class Coordenada {
    private int x;
    private int y;
    private Cardinalidad c;

    public Coordenada(){
        x = 0;
        y = 0;
        c = Cardinalidad.Norte;
    }
    public Coordenada(int x, int y, Cardinalidad c){
        this.x = x;
        this.y = y;
        this.c = c;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Cardinalidad getC() {
        return c;
    }
}
