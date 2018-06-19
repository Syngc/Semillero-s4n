package co.com.s4n.semillero.ejercicio;

//vavr
import io.vavr.collection.List;

//JUnit5
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
//Java
import java.util.LinkedList;


//Mockito
import static org.mockito.Mockito.*;

//PowerMock

@RunWith(PowerMockRunner.class)
class dependencias {

    @Test
    void smokeTest(){
        assertTrue(true);
    }

    @Test
    void mockitoTest(){
        // you can mock concrete classes, not only interfaces
        LinkedList mockedList = mock(LinkedList.class);

        // stubbing appears before the actual execution
        when(mockedList.get(0)).thenReturn("first");

        // the following prints "first"
        System.out.println(mockedList.get(0));

        // the following prints "null" because get(999) was not stubbed
        System.out.println(mockedList.get(999));
    }

    @Test
    void powerMockTest(){

    }



}
