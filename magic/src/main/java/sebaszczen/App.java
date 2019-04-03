package sebaszczen;

import sebaszczen.zabawa.Man;
import sebaszczen.zabawa.MyException;

import java.util.*;

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
