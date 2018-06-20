package co.com.s4n.semillero.ejercicio;


import co.com.s4n.semillero.ejercicio.dominio.entidades.Coordenada;
import co.com.s4n.semillero.ejercicio.dominio.vo.Cardinalidad;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;

import static co.com.s4n.semillero.ejercicio.dominio.servicios.servicioCoordenada.*;
import static co.com.s4n.semillero.ejercicio.dominio.vo.Cardinalidad.*;
import static junit.framework.TestCase.*;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
public class CoordenadaTest{
    private Coordenada coordenada;

    @Test
    public void smokeTest(){
        assertTrue(true);
    }

    @Before
    public void setupMock(){
        coordenada = Mockito.mock(Coordenada.class);
    }

    @Test
    public void testCrear(){
        when(coordenada.getX()).thenReturn(0);
        when(coordenada.getY()).thenReturn(0);
        when(coordenada.getC()).thenReturn(Norte);

        //Run
        int x = coordenada.getX();
        int y = coordenada.getY();
        Cardinalidad c = coordenada.getC();
    }

    @Test
    public void testRotarIzquierda(){
        Coordenada c = new Coordenada(2,2, Norte);
        Coordenada res = rotarIzquierda(c);
        Coordenada exp = new Coordenada(2,2, Oeste);
        assertEquals(exp.getX(),res.getX());
        assertEquals(exp.getY(),res.getY());
        assertEquals(exp.getC(),res.getC());
    }

    @Test
    public void testRotarDerecha(){
        Coordenada c = new Coordenada(2,2, Norte);
        Coordenada res = rotarDerecha(c);
        Coordenada exp = new Coordenada(2,2, Este);
        assertEquals(exp.getX(),res.getX());
        assertEquals(exp.getY(),res.getY());
        assertEquals(exp.getC(),res.getC());
    }

    @Test
    public void testAvanzarNorte(){
        Coordenada c = new Coordenada(2,2, Norte);
        Coordenada res = avanzar(c);
        Coordenada exp = new Coordenada(2,3, Norte);
        assertEquals(exp.getX(),res.getX());
        assertEquals(exp.getY(),res.getY());
        assertEquals(exp.getC(),res.getC());
    }

    @Test
    public void testActualizar(){
        Coordenada c = new Coordenada();
        String s = "AAAAIAAD";
        Coordenada res = mover(c, s);
        Coordenada exp = new Coordenada(-2,4, Norte);
        assertEquals(exp.getX(),res.getX());
        assertEquals(exp.getY(),res.getY());
        assertEquals(exp.getC(),res.getC());

    }

    @Test
    public void testCalcularDistancia(){
        Coordenada m = new Coordenada(2, 2, Norte);
        Double ans = calcularDistancia(m);
        assertTrue(Math.abs(ans - 2.828) < 0.001 );

    }

    @Test
    public void testValidarDistancia(){
        Coordenada m = new Coordenada(2, 2, Norte);
        Double d = calcularDistancia(m);
        Boolean ans = verificarDistancia(d);
        assertTrue(ans);
    }

    @Test
    public void testValidarDistanciaFalse(){
        Coordenada m = new Coordenada(8, 8, Norte);
        Double d = calcularDistancia(m);
        Boolean ans = verificarDistancia(d);
        assertFalse(ans);
    }

    @Test
    public void testValidarDistanciaFalse2(){
        Coordenada m = new Coordenada(0, 10, Norte);
        Double d = calcularDistancia(m);
        Boolean ans = verificarDistancia(d);
        assertFalse(ans);
    }

}
