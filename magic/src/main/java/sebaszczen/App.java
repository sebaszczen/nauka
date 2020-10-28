package sebaszczen;

import sebaszczen.zabawa.Man;
import sebaszczen.zabawa.MyException;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
//        int[] tablica = {1, 2, 3, 4, 5};
//        Arrays.stream(tablica).filter(x->x%2==0).forEach(System.out::println);
//
//        Set set = new LinkedHashSet();

//        callExeption();

        IntStream.range(1,6).filter(x->x>3).map(x->x*2).forEach(System.out::println);
        int x = 0;
        for (int i = 0; i < 14; i++) {
            x += i;
        }
    }

    private static void callExeption() {
        try {
            callExc(32);
        } catch (MyException e) {

            e.printStackTrace();
        }
    }

    public static void callExc(int x) throws MyException {
        throw new MyException("uciekaj"+x);

    }
}



