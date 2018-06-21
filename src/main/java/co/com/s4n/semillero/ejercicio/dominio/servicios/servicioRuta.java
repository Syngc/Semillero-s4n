package co.com.s4n.semillero.ejercicio.dominio.servicios;

import co.com.s4n.semillero.ejercicio.dominio.entidades.Coordenada;
import co.com.s4n.semillero.ejercicio.dominio.entidades.Instruccion;
import io.vavr.collection.CharSeq;
import io.vavr.collection.List;
import java.util.ArrayList;

import static co.com.s4n.semillero.ejercicio.dominio.servicios.servicioCoordenada.calcularDistancia;
import static co.com.s4n.semillero.ejercicio.dominio.servicios.servicioCoordenada.mover;
import static co.com.s4n.semillero.ejercicio.dominio.servicios.servicioCoordenada.verificarDistancia;

public class servicioRuta {

    public static List<String> verificarRuta(List<String> l){
        final String REGEX_RUTA = "[AID]*";
        List<String> vl = l.filter(a -> CharSeq.of(a).matches(REGEX_RUTA));
        return vl;
    }


    public static List<Instruccion> recorrerRuta(List<Instruccion> lista){
        Instruccion i = new Instruccion("" ,new Coordenada());
        java.util.List<Instruccion> li = new ArrayList<>();
        lista.fold(i, (prev, act) -> {
                Instruccion aux = mover(prev, act);
                if(verificarDistancia(calcularDistancia(aux))){
                    li.add(aux);
                }
                return aux;
            });
        List<Instruccion> lf = li.stream().collect(List.collector());
        return lf;
    }


    public static List<Instruccion> generarInstrucciones(List<String> lista){
        Coordenada c = new Coordenada();
        List<Instruccion> instrucciones = lista.map(i -> new Instruccion(i, c));
        return instrucciones;
    }




}
