package multiTh.streamParaller;

import java.util.Arrays;
import java.util.stream.IntStream;

public class NumberCounterek {

    public static void main(String[] args) {
        int high = 1000000;
        int[] numbers = new int[high-2];

        for(int i =0; i<numbers.length; i++) {
            numbers[i] = i+2;
        }

        long start = System.currentTimeMillis();
        long count = Arrays.stream(numbers).filter(v -> isPrime(v)).count();
        long end = System.currentTimeMillis();
        System.out.printf("Number of prime numbers <= %d equals %d\n", high,count);
        System.out.printf("Calc. time was: %d [ms]\n", end - start);
        System.out.println();

        long startP = System.currentTimeMillis();
        long countP = Arrays.stream(numbers).parallel().filter(v -> isPrime(v)).count();
        long endP = System.currentTimeMillis();
        System.out.printf("Number of prime numbers <= %d equals %d\n", high,countP);
        System.out.printf("Calc. time was: %d [ms]\n", endP - startP);
    }

    public static boolean isPrime(int number) {
//        for (int i = 2; i <= number / 2; i++) {
//            if (number % i == 0) {
//                return false;
//            }
//        }
        return number>2 && IntStream.rangeClosed(2, (int)Math.sqrt(number)).noneMatch(n-> (number % n == 0));
    }
}
