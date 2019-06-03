package maciek.pl.threads.jointhread;

import java.util.Vector;

public class JoinThread {
    public static void main(String[] args) {
        Vector<String> s = new Vector<>();
        s.add("XXX");
        s.add("AAA");
        s.add("Marek");
        s.add("Beata");
        s.add("Warka");

        s.forEach(System.out::println);

        System.out.println("sss@@@@@@@@@@@@@@@@@2");
        s.sort(String::compareToIgnoreCase);
        s.sort((o1, o2) -> -1);
        s.forEach(System.out::println);

    }
}
