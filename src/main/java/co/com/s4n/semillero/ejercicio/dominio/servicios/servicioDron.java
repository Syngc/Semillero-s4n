package co.com.s4n.semillero.ejercicio.dominio.servicios;


import co.com.s4n.semillero.ejercicio.dominio.entidades.Instruccion;
import io.vavr.collection.Iterator;
import io.vavr.collection.List;
import java.nio.file.Path;
import static co.com.s4n.semillero.ejercicio.dominio.Archivos.escribirArchivo;
import static co.com.s4n.semillero.ejercicio.dominio.Archivos.leerArchivo;
import static co.com.s4n.semillero.ejercicio.dominio.Archivos.listarPedidos;
import static co.com.s4n.semillero.ejercicio.dominio.servicios.servicioRuta.generarInstrucciones;
import static co.com.s4n.semillero.ejercicio.dominio.servicios.servicioRuta.recorrerRuta;
import static co.com.s4n.semillero.ejercicio.dominio.servicios.servicioRuta.verificarRuta;


public class servicioDron {



    public static Iterator<List<Instruccion>> hacerRecorrido(List<Instruccion> r, int numMax){
        Iterator<List<Instruccion>> grouped = r.grouped(numMax);
        Iterator<List<Instruccion>> rutas = grouped.map(x -> recorrerRuta(x));
        return rutas;
    }


    public static boolean enviarDron(){
        Path a = listarPedidos().get().get(0);
        escribirArchivo(hacerRecorrido(generarInstrucciones(verificarRuta(leerArchivo(a))), 3), "out.txt");
        return true;
    };



}
