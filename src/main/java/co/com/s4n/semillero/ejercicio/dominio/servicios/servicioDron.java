package co.com.s4n.semillero.ejercicio.dominio.servicios;

import co.com.s4n.semillero.ejercicio.dominio.entidades.Coordenada;
import co.com.s4n.semillero.ejercicio.dominio.entidades.Dron;
import co.com.s4n.semillero.ejercicio.dominio.entidades.Ruta;
import io.vavr.collection.Iterator;
import io.vavr.collection.List;
import io.vavr.concurrent.Future;

import static co.com.s4n.semillero.ejercicio.dominio.Archivos.escribirArchivo;
import static co.com.s4n.semillero.ejercicio.dominio.Archivos.leerArchivo;


public class servicioDron {

    public static Dron asignarRuta(Ruta r){
        return new Dron(r);
    }



    public static void hacerRecorrido(Dron d){
        Ruta r = d.getRuta();
        List list = r.getRuta();
        Iterator<List<Coordenada>> grouped = list.grouped(3);
        grouped.map(g -> escribirArchivo(g));
    }

}
