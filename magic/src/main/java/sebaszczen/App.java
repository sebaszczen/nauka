package sebaszczen;

import sebaszczen.zabawa.Man;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int[] tablica = {1, 2, 3, 4, 5};
        Arrays.stream(tablica).filter(x->x%2==0).forEach(System.out::println);
    }
}
