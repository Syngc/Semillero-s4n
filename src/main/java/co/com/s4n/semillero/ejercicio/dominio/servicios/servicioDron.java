package co.com.s4n.semillero.ejercicio.dominio.servicios;


import co.com.s4n.semillero.ejercicio.dominio.entidades.Instruccion;
import io.vavr.collection.Iterator;
import io.vavr.collection.List;
import io.vavr.concurrent.Future;

import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;


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


    public static boolean enviarDron(Path a){
        String sa = a.getFileName().toString().substring(2,4);
        if(isNumeric(sa)){
            escribirArchivo(hacerRecorrido(generarInstrucciones(verificarRuta(leerArchivo(a))), 10), "out"+sa+".txt");
        }
        return true;
    }

    private static boolean isNumeric(String s) {
        Pattern pattern = Pattern.compile("^[0-9]*$");
        return s != null &&  pattern.matcher(s).matches();
    }

    ;

    public static void enviarDrones(){
        List<Path> paths = listarPedidos().get();
        ExecutorService service = Executors.newFixedThreadPool(20);
        paths.flatMap(a -> Future.of(service, () ->{
                    return enviarDron(a);
                })
        );


    }





}
