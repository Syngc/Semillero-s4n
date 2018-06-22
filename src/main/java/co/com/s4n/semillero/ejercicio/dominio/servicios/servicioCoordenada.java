package co.com.s4n.semillero.ejercicio.dominio.servicios;

import co.com.s4n.semillero.ejercicio.dominio.entidades.Coordenada;
import co.com.s4n.semillero.ejercicio.dominio.entidades.Instruccion;
import co.com.s4n.semillero.ejercicio.dominio.vo.Cardinalidad;

import static co.com.s4n.semillero.ejercicio.dominio.vo.Cardinalidad.*;

public class servicioCoordenada {



    public static Instruccion mover(Instruccion c, Instruccion s){
        char[] array = s.getRuta().toCharArray();
        Coordenada nc = c.getCoordenada();
        for (char e: array) {
            switch (e) {
                case 'A': nc = avanzar(nc); break;
                case 'I': nc = rotarIzquierda(nc); break;
                case 'D': nc = rotarDerecha(nc); break;
                default: break;
            }
        }
        return new Instruccion(" ", nc);
    }

    public static Coordenada avanzar(Coordenada c){
        int x = c.getX();
        int y = c.getY();
        Cardinalidad z = c.getC();
        switch (z) {
            case Norte: y =  y + 1; break;
            case Sur: y =  y - 1; break;
            case Este: x = x + 1; break;
            case Oeste: x = x - 1; break;
            default: break;
        }
        return new Coordenada(x,y,z);
    }

    public static Coordenada rotarIzquierda(Coordenada c){
        int x = c.getX();
        int y = c.getY();
        Cardinalidad z = c.getC();
        switch (z) {
            case Norte: z = Oeste; break;
            case Sur: z = Este; break;
            case Este: z = Norte; break;
            case Oeste: z = Sur; break;
            default: break;
        }
        return new Coordenada(x,y,z);
    }

    public static Coordenada rotarDerecha(Coordenada c){
        int x = c.getX();
        int y = c.getY();
        Cardinalidad z = c.getC();
        switch (z) {
            case Norte: z = Este; break;
            case Sur: z = Oeste; break;
            case Este: z = Sur; break;
            case Oeste: z = Norte; break;
            default: break;
        }
        return new Coordenada(x,y,z);
    }

    public static Double calcularDistancia(Instruccion c){
        int x = c.getCoordenada().getX();
        int y = c.getCoordenada().getY();
        Double ans = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
        return ans;
    }

    public static boolean verificarDistancia(Double d){
        return  d < 10 ? true : false;
    }

}
