package co.com.s4n.semillero.ejercicio.dominio.entidades;


public class Instruccion{
    String ruta;
    Coordenada coordenada;

    public Instruccion(String ruta, Coordenada coordenada){
        this.ruta = ruta;
        this.coordenada = coordenada;
    }

    public String getRuta() {
        return ruta;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }
}