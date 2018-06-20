package co.com.s4n.semillero.ejercicio.dominio;

import co.com.s4n.semillero.ejercicio.dominio.entidades.Coordenada;
import co.com.s4n.semillero.ejercicio.dominio.entidades.Ruta;
import io.vavr.collection.List;
import io.vavr.control.Either;
import io.vavr.control.Try;

import java.io.BufferedReader;
import java.io.FileReader;

public class Archivos {

    public static Either<String, List<String>> leerArchivo(String s){
        Either<String,List<String>> f = Try.of(() -> {
            BufferedReader reader = new BufferedReader(new FileReader("./src/main/resources/" + s ));
            List<String> l = List.of();
            String direccion;
            while((direccion = reader.readLine()) != null) {
                l = l.push(direccion);
            }
            return l;
        }).toEither("El archivo no ha sido encontrado");
        return f;
    }

    public static Boolean escribirArchivo(List<Coordenada> c){
        return true;
    }
}
