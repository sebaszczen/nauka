package maciek.pl.cucuTest;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Testujemy {

    @Test
    public void name() {
        List<Integer> list = new ArrayList(Arrays.asList(new Integer(1), new Integer(23)));
        Stream<Integer> integerStream = list.parallelStream();
        Assert.assertTrue(integerStream.isParallel());
        Integer reduce = list.parallelStream().reduce(2324, Integer::sum);
        System.out.println(reduce);
    }
}
