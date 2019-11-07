package sebaszczen.unittesting;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

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
}
