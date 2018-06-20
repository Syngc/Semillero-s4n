package co.com.s4n.semillero.ejercicio;

import io.vavr.collection.List;
import io.vavr.control.Try;
import org.junit.Test;

import static co.com.s4n.semillero.ejercicio.dominio.servicios.servicioRuta.leerArchivo;
import static io.vavr.collection.List.*;
import static org.junit.Assert.*;

public class RutaTest {

    @Test
    public void testLeerArchivo(){
        Try<List<String>> t =  leerArchivo("in.txt");
        List l = List.of("empty");
        assertEquals(t.getOrElseGet(l), List.of("AAAAIAAD"));
        assertTrue(t.isSuccess());
    }
}
