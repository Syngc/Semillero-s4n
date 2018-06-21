package co.com.s4n.semillero.ejercicio.dominio;

import co.com.s4n.semillero.ejercicio.dominio.entidades.Instruccion;
import io.vavr.collection.Iterator;
import io.vavr.collection.List;
import io.vavr.control.Try;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Archivos {

    public static  Try<List<Path>> listarPedidos(){
        Try<Stream<Path>> tf = Try.of(() -> Files.walk(Paths.get("./src/main/resources/in")));
        return Try.of(() -> tf.get().collect(List.collector()).tail());
    }


   public static List<String> leerArchivo(Path ruta){
        Try<List<String>> f = Try.of(() -> {
            List<String> l = List.of();
            if (Files.isRegularFile(ruta)) {
                BufferedReader reader = new BufferedReader( new FileReader(ruta.toString()));

                String direccion;
                while((direccion = reader.readLine()) != null) {
                    l = l.append(direccion);
                }
            }
            return l;
        });
        if(f.isSuccess()) return f.get();
        return null;
    }



    public static void escribirArchivo(Iterator<List<Instruccion>> coordenadas, String n){
        Try<Boolean> of = Try.of(() -> {
            File file = new File("./src/main/resources/out/" + n);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.printf("====== Reporte de entregas =======\n");
            coordenadas.forEach(a -> imprimir(printWriter, a));
            printWriter.close();
            return true;
        });

    }

    public static void imprimir(PrintWriter p ,List<Instruccion> i){
        i.forEach(b ->
        p.printf("(" + b.getCoordenada().getX() + "," + b.getCoordenada().getY() + ") dirección " + b.getCoordenada().getC().name()+"\n"));
    }
}
