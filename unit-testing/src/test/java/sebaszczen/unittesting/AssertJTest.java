package sebaszczen.unittesting;

import org.junit.Test;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Writer;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


public class AssertJTest {

    @Test
    public void learning() {
        List<Integer> integers = Arrays.asList(12, 15, 45);
//        assertThat(integers, hasSize(3));
        assertThat(integers).hasSize(3).contains(12,45);
//        assertThat(integers,hasItems(12,45));
        assertThat(integers).contains(12, 45).allMatch(x->x>10).allMatch(x->x<100).noneMatch(x->x.equals(20));
//        assertThat(integers,everyItem(greaterThan(10)));
//        assertThat(integers,everyItem(lessThan(100)));
//        assertThat("abcd",containsString("ab"));
//        assertThat("",isEmptyString());
        assertThat("").isEmpty();
        assertThat("").isNotEqualTo("sd");
        assertThat("abc").startsWith("a").contains("b");
//        assertThat("abc",startsWith("a"));
//        assertThat("abc",endsWith("bc"));
    }

    @Test
    public void name() {
        A a = new B();
        System.out.println(((B) a).getName());
        System.out.println(((C) a).nameC());
        System.out.println(((A) a).getName());

        ArrayList<Integer> adj[] = new ArrayList[2];

    }

    interface A {
        String getName();
    }

    class B extends C implements A{
        @Override
        public String getName() {
            return "class a";
        }
    }

    class C {
        String nameC() {
            return "class c";
        }
    }


}
