package co.com.s4n.semillero.ejercicio.dominio.servicios;

import co.com.s4n.semillero.ejercicio.dominio.entidades.Coordenada;
import co.com.s4n.semillero.ejercicio.dominio.entidades.Dron;
import co.com.s4n.semillero.ejercicio.dominio.entidades.Ruta;
import io.vavr.collection.CharSeq;
import io.vavr.collection.List;



import static co.com.s4n.semillero.ejercicio.dominio.servicios.servicioCoordenada.mover;

public class servicioRuta {

    public static List<String> verificarRuta(List<String> l){
        final String REGEX_RUTA = "[AID]*";
        List<String> vl = l.filter(a -> CharSeq.of(a).matches(REGEX_RUTA));
        return vl;
    }

    public static Ruta generarRuta(List<String> lista){
        Coordenada c = new Coordenada();
        List<Coordenada> lc = lista.map(x -> mover(c, x));
        Ruta r = new Ruta(lc);
        return r;
    }






}
