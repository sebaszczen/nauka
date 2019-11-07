package sebaszczen.unittesting;

import org.assertj.core.internal.Integers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersTest {

    @Test
    public void learning() {
        List<Integer> integers = Arrays.asList(12, 15, 45);
        assertThat(integers, hasSize(3));
        assertThat(integers,hasItems(12,45));
        assertThat(integers,everyItem(greaterThan(10)));
        assertThat(integers,everyItem(lessThan(100)));
        assertThat("abcd",containsString("ab"));
        assertThat("",isEmptyString());
        assertThat("abc",startsWith("a"));
        assertThat("abc",endsWith("bc"));
    }
}
