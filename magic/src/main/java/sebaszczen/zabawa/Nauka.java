package sebaszczen.zabawa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Nauka {
    public static void main(String[] args) {
//        Integer int1 = new Integer(1);
//        Integer int2 = new Integer(1);
//
//        String x = "a";
//        String a = "a";
//
//        Double q = 1.0;
//        Double w = 1.0;
//
//        System.out.println(int1 == int2);
//        System.out.println(x==a);
//        System.out.println(q==w);


//        List<Integer> list = new ArrayList<>();
//        list.add(new Integer(1));
//        list.add(2);
//        list.add(new Integer(1));
//        Set<Integer> set = new HashSet<>();
//        set.addAll(list);
//        System.out.println(set);


        String x = new String("aaa");
        String a = new String("aaa");
        System.out.println(x.equals(a));

        Man man=new Man();
        man.setName("adam");
        Man man1 = new Man();
        man1.setName("adam");
        System.out.println(man.equals(man1));

    }
}
