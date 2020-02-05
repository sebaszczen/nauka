package sebaszczen;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void name() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Person.class);
//        String xx = "tomek";
        enhancer.setCallback( (FixedValue)()->"Hello Tom!");
        Person proxy = (Person) enhancer.create();

        String s = proxy.sayHello(null);

        assertEquals("Hello Tom!", s);
    }
}