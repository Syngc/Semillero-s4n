package co.com.s4n.semillero.ejercicio;

import co.com.s4n.semillero.ejercicio.dominio.entidades.Coordenada;
import co.com.s4n.semillero.ejercicio.dominio.entidades.Ruta;
import io.vavr.collection.List;
import io.vavr.control.Try;
import org.junit.Test;

import java.nio.file.Path;

import static co.com.s4n.semillero.ejercicio.dominio.Archivos.leerArchivo;
import static co.com.s4n.semillero.ejercicio.dominio.Archivos.listarPedidos;
import static co.com.s4n.semillero.ejercicio.dominio.servicios.servicioCoordenada.mover;
import static co.com.s4n.semillero.ejercicio.dominio.servicios.servicioRuta.*;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class RutaTest {

    @Test
    public void testVerificarRuta(){
        Try<List<Path>> pedidos = listarPedidos();
        List<Path> paths = pedidos.get();
        List<String> ruta = leerArchivo(paths.get(0));
        List<String> rutaVerificada = verificarRuta(ruta);
        System.out.println(rutaVerificada);
    }



}
