package sebaszczen;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Optional;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
//    @Test
//    public void shouldAnswerWithTrue()
//    {
//        assertTrue( true );
//    }
//
//    @Test
//    public void givenFixedClock_whenNow_thenGetFixedInstant() {
//        String instantExpected = "2014-12-22T10:15:30Z";
//        Clock clock = Clock.fixed(Instant.parse(instantExpected), ZoneId.of("UTC"));
//
//        Instant instant = Instant.now(clock);
//
//        System.out.println(Calendar.getInstance().getTime());
//    }
//
//    @Test
//    public void optional() {
//        String x = null;
//        Optional<String> o = Optional.ofNullable(x);
//        System.out.println(o.orElse("xx"));
//    }
    @Test
    public void test1() {
        Codewars codewars = new Codewars();
        Assert.assertEquals(1,codewars.increment());
    }

    @Test
    public void test2() {
        Codewars codewars = new Codewars();
        Assert.assertEquals(2,codewars.increment());
    }
}
