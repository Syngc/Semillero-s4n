package co.com.s4n.semillero.ejercicio.dominio.entidades;

import co.com.s4n.semillero.ejercicio.dominio.vo.Cardinalidad;

public class Dron {
    public Ruta ruta;

    public Dron(){
        ruta = new Ruta();
    }

    public Dron(Ruta ruta){
         this.ruta = ruta;
    }

    public Ruta getRuta() {
        return ruta;
    }


}
