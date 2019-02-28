package pl.threads.testy;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class RidableDuckTestApp {
    public static void main(String[] args) {

//        new Duck().go(8);

//        String s1 = "this is index of example";
//        int index1 = s1.indexOf("is");//returns the index of is substring
//        int index2 = s1.indexOf("le");//returns the index of index substring
//        System.out.println(index1 + "  " + index2);//2 8  ;


//            String in = "1";
//            Scanner s = new Scanner(System.in);
//            int accum = 0;
//            for (int x = 0; x < 4; x++) {
//                accum += s.nextInt();
//            }
//            System.out.println(accum);

        Queue<String> products = new ArrayDeque<String>();
        products.add("p1");
        products.add("p2");
        products.add("p3");
        System.out.print(products.peek());
        System.out.print(products.poll());
        System.out.println("");
        products.forEach(s -> System.out.print(s));

    }


}

