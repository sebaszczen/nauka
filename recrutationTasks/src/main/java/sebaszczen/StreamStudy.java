package sebaszczen;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Random;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamStudy {

    static Logger logger = Logger.getLogger(StreamStudy.class.getName());

    public static void main(String[] args) {
        System.out.println(" xxx x ");
        System.out.println("xxx x ");
        generate5RandomNumbersLimitedTo6();
        generate4RandomNumbers();
        stringStream();
        reduceLEarn();
    }

    private static void stringStream() {
        System.out.println("\nstringStream");
        IntStream chars = "sylwia".chars();
        chars.forEach(x-> System.out.println((char)x));
    }

    private static void reduceLEarn() {
        System.out.println("\nreduceLEarn");

        OptionalInt reduced =
                IntStream.range(1, 4).reduce((a, b) -> a + b);
        System.out.println(reduced.getAsInt());

        int reducedParallel = Arrays.asList(1, 2, 3).parallelStream()
                .reduce(10, (a, b) -> a + b, (a, b) -> {
                    logger.info("combiner was called");
                    return a + b;
                });
        System.out.println(reducedParallel);
    }

    private static void generate4RandomNumbers() {
        System.out.println("\ngenerate4RandomNumbers");
        Random random = new Random();
        random.ints(3).forEach(System.out::println);
    }

    private static void generate5RandomNumbersLimitedTo6() {
        System.out.println("\ngenerate5RandomNumbersLimitedTo6");
        Random random = new Random();
        Stream<Integer> limit = Stream.generate(() -> random.nextInt(6)).limit(5);
        limit.forEach(System.out::println);
    }
}