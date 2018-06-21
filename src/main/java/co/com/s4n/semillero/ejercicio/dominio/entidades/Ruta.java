package co.com.s4n.semillero.ejercicio.dominio.entidades;

import io.vavr.collection.List;

public class Ruta {
    List<Coordenada> ruta;

    public  Ruta(){};

    public  Ruta(List<Coordenada> ruta){ this.ruta = ruta;}

    public List<Coordenada> getRuta() {
        return ruta;
    }

}
