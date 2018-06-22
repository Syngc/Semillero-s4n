package co.com.s4n.semillero.ejercicio;


import co.com.s4n.semillero.ejercicio.dominio.entidades.Coordenada;
import co.com.s4n.semillero.ejercicio.dominio.entidades.Instruccion;
import io.vavr.collection.Iterator;
import io.vavr.collection.List;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static co.com.s4n.semillero.ejercicio.dominio.Archivos.*;
import static co.com.s4n.semillero.ejercicio.dominio.vo.Cardinalidad.*;
import static junit.framework.TestCase.*;

@RunWith(PowerMockRunner.class)
public class ArchivoTest {

    @Test
    public void  testListarPedidos(){
        Try<List<Path>> pedidos = listarPedidos();
        assertTrue(pedidos.isSuccess());
        pedidos.get().flatMap(x -> {
            System.out.println(x.toString());
            return x;
        });
    }

    @Test
    public void testLeerArchivo(){
        Try<List<Path>> pedidos = listarPedidos();
        List<Path> paths = pedidos.get();
        List<String> ruta = leerArchivo(paths.get(0));
        System.out.println(ruta.get());
    }

    @Test
    public void testCrearArchivo(){
        try{
            File file= new File ("./src/main/resources/out/out.txt");
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.printf("====== Reporte de entregas =======");
            printWriter.close();
        }catch(IOException e) {
            System.out.println("error");
        }
    }

    @Test
    public void tesCrearImprimir(){
        Instruccion a1 = new Instruccion(" ", new Coordenada(1,2,Norte));
        Instruccion a2 = new Instruccion(" ", new Coordenada(2,3,Sur));
        Instruccion a3 = new Instruccion(" ", new Coordenada(1,2,Este));
        List<Instruccion> a = List.of(a1,a2,a3);

        Instruccion b1 = new Instruccion(" ", new Coordenada(4,2,Norte));
        Instruccion b2 = new Instruccion(" ", new Coordenada(1,3,Sur));
        Instruccion b3 = new Instruccion(" ", new Coordenada(7,2,Este));
        List<Instruccion> b = List.of(b1,b2,b3);

        Iterator i = Iterator.of(a,b);
        escribirArchivo(i,"out.txt");
    }
}
