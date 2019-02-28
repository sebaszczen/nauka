package pl.basic;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

public class palindromCheck {
    public static void main(String[] args) {
        System.out.println(pali("Zakopane na pokaz"));
//        System.out.println(a/2);
   }

    static boolean pali(String wordp) {
        String wordl = wordp.toLowerCase().replaceAll(" ", "");
        AtomicBoolean chars = new AtomicBoolean(false);
        int length = wordl.length();
        IntStream.range(0, length / 2).forEach(t -> {
            if (wordl.charAt(t) == wordl.charAt(length - 1 - t)) {
                chars.set(true);
            } else {
                chars.set(false);
            }
        });
        return chars.get();
//        for (int n = 0; n< wordp.length()/2 ;n++) {
//                if (wordp.charAt(n) == wordp.charAt(length - 1-n)) {
//                    chars = true;
//                } else {
//                    chars = false;
//                }
//            }
//
////        }
//        return chars;
//    }
    }
}
