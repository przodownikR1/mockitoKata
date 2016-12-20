package pl.java.scalatech.simple;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class SpyTest {

    @Test
    public void stubTest() {
        List list = new LinkedList();
        List spy = Mockito.spy(list);

        // optionally, you can stub out some methods:
        when(spy.size()).thenReturn(100);

        // using the spy calls *real* methods
        spy.add("one");
        spy.add("two");

        // prints "one" - the first element of a list
        System.out.println(spy.get(0));

        // size() method was stubbed - 100 is printed
        System.out.println(spy.size());

        // optionally, you can verify
        verify(spy).add("one");
        verify(spy).add("two");
    }
}
