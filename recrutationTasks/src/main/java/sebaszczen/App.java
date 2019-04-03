package sebaszczen;

import com.sun.deploy.util.ArrayUtil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //findShared part of two arrays
//        int[] a = new int[]{1, 2,3,0, 4,5, 6, 7};
//        int[] b = new int[]{2, 4, 7,9,0};
//        int[] shared = findShared(a, b);
//        for (int i : shared) {
//            System.out.println(i);
//        }

//        check if palindrom
//        System.out.println(checkIfPalindrom("Kobyła ma mały bok"));

        //cwiczymy seta
//        set();

//        System.out.println("------forEachVsIterator---------");
//        forEachVsIterator();

//        System.out.println("------findSecondSmallestElementInArray---------");
//        findSecondSmallestElementInArray(new int[]{7,4,5,1});

        //        System.out.println("------sortArrayOfInteger---------");
        sortArrayOfInteger(new int[]{new Integer(100000),new Integer(9), new Integer(5), new Integer(4)});
    }

    private static void sortArrayOfInteger(int[] ints) {
//        Arrays.sort(ints);
//        System.out.println(Arrays.toString(ints));

//        Integer[] a = Arrays.stream(ints).boxed().toArray(Integer[]::new);
//        Arrays.sort(a, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1>o2?-1:1;
//            }
//        });
//        System.out.println(Arrays.toString(a));
//
//        //sortuje tablice od 2 indeksu
//        Arrays.sort(ints,2,ints.length);
//        System.out.println(Arrays.toString(ints));

        int[] a = {8, 6, 7, 5, 3, 0, 9};
        int[] b = IntStream.rangeClosed(1, a.length).map(i -> a[a.length-i]).toArray();
        System.out.println(Arrays.toString(b));
        System.out.println("ssasdsddf");
    }

    private static void findSecondSmallestElementInArray(int[]tablica){
        Arrays.sort(tablica);
        System.out.println(tablica[1]);
        int[] ints = Arrays.stream(tablica).boxed().sorted(Comparator.reverseOrder()).mapToInt(x -> x).toArray();
        Integer[] integers = Arrays.stream(tablica).boxed().sorted(Comparator.reverseOrder()).toArray(Integer[]::new);
        System.out.println(Arrays.toString(ints));


    }



    private static boolean checkIfPalindrom(String sentence) {
        String s = sentence.replaceAll(" ", "");
        String s1 = new StringBuilder(s).reverse().toString();
        return s1.equalsIgnoreCase(s);
    }

    private static int[] findShared(int[] a, int[] b) {
        int[] ints = Arrays.stream(a).filter(x ->
                Arrays.stream(b).anyMatch(q -> q == x)
        ).toArray();
        return ints;
    }

    private static void set() {
        Set<Integer> collect = IntStream.range(1, 100).boxed().collect(Collectors.toCollection(HashSet::new));

        System.out.println("------HashSet---------");
        System.out.println("kolejnosc losowa");

        Set<String> hashSet = new HashSet<>(Arrays.asList("a", "sdfb", "csdf","dsdfff","e"));
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("------linkedHashSet---------");

        Set<String> linkedHashSet = new LinkedHashSet<>(Arrays.asList("a", "sdfb", "csdf","dsdfff","e"));
        Iterator<String> iterator1 = linkedHashSet.iterator();
        System.out.println("kolejnosc w jakiej został utowrzony zbiór");
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        System.out.println("------TreeSet---------");
        Set<String> treeSet = new TreeSet<>(Arrays.asList("a", "sdfb", "csdf","dsdfff","e"));
        Iterator<String> iterator2 = treeSet.iterator();
        System.out.println("kolejność alfabetyczna");
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }



    }

    private static void forEachVsIterator() {

        List<Integer> l = new LinkedList<Integer>();

        // Now add elements to the Link List
        l.add(2);
        l.add(3);
        l.add(4);

        // Make another Link List which stores integer elements
        List<Integer> s=new LinkedList<Integer>();
        s.add(7);
        s.add(8);
        s.add(9);

        s.forEach(System.out::println);

        for (Integer integer : s) {
            integer=integer +2;
        }
        for (Integer integer : s) {
            System.out.println(integer);
        }

        List<Person> personList = new ArrayList<>(Arrays.asList(new Person(1),new Person(23)));


        for (Person person : personList) {
            person.setAge(23);
            personList.set(1, new Person(222));

        }
        for (Person person : personList) {
            System.out.println(person.getAge());
        }

        // Iterator to iterate over a Link List
//        for (Iterator<Integer> itr1=l.iterator(); itr1.hasNext(); )
//        {
//            for (Iterator<Integer> itr2=s.iterator(); itr2.hasNext(); )
//            {
//                if (itr1.hasNext()&& itr1.next() < itr2.next())
//                {
//                    System.out.println(itr1.next());
//                }
//            }
//        }
    }
}
