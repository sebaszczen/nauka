package maciek.pl.basic;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Integer.valueOf;

public class BasicApp {

    public static void main(String[] args) {
//        System.out.println("SUMA CYFR ZE STRINA-> " + sumNumbersFromString("1Mecz 2Druzyny, 45min gry1"));
//        String test = "1Mecz 2Druzyny, 45min gry1";
//        String[] dubelki = test.split(" ");
//        for (String s : dubelki) {
//            System.out.println(s);
//        }
//        System.out.println(findDoubledChars("Krowwia"));
//        System.out.println(findDoubledStrings("str sara"));

        List<String> strr = new ArrayList<>();
        strr.add("Ala");
        strr.add("xla");
        strr.add("zla");
        strr.add("cla");
        strr.add("cla");
        strr.add("zza");
//        Set<String> strSt = new HashSet<>();
//
        System.out.println("NON DUBLES-> " + nonDubles("str str str aar rar ora mor"));
        System.out.println(doubless("xxx str str str aar rar ora ora ora mor"));


//        List<Integer> x = listFromString("1 2 3 4 1 8 9 10 3 4 5 5");
//        System.out.println(x);
//        System.out.println(avg(x));
//        System.out.println(maxFromLst(x));
//
//        System.out.println(countier(strr));
//        System.out.println(sortList(strr));
    }



    public static int sumNumbersFromString(String text) {
        String numbers = text.replaceAll("[^0-9]", "");
        int result = 0;
        for (int i = 0; i < numbers.length(); i++) {
            String s = "" + numbers.charAt(i);
            result += valueOf(s);
        }
        return result;
    }

    public static boolean findDoubledChars(String text) {
        char[] chars = text.toCharArray();
        Set<Character> set = new HashSet<>();
        IntStream.range(0, chars.length).forEach(i->set.add(chars[i]));
        return set.size()!=chars.length;

    }

    //true jak sa powtorzeone wyrazy
    public static boolean findDoubledStrings(String text) {
        Set<String> setStrings = new HashSet<>();
        String[] stringArray = text.split(" ");
        IntStream.range(0, stringArray.length).forEach(t-> setStrings.add(stringArray[t]));
        return setStrings.size()!=stringArray.length;
    }

    //zwraca posortowaną kolekcje
    public static List<String> sortList(List<String> unsortet) {
//        Collections.sort(unsortet);
//       Collections.reverse(unsortet);
        String max = Collections.max(unsortet);
        System.out.println("MAAAXX MaX " + max);
        Collections.sort(unsortet);
        Collections.reverse(unsortet);
        return unsortet;
    }

    public static String nonDubles(String text) {
        String[] strings = text.split(" ");
        Set<String> nonDubles = new HashSet<>();
        for (String string : strings) {
            nonDubles.add(string);
        }
        return nonDubles.stream().collect(Collectors.joining(" "));
    }

    public static List<Integer> listFromString(String numbers) {
        String[] split = numbers.split(" ");
        List<Integer> resutList = new ArrayList<>();
        for(String s : split) {
            resutList.add(Integer.parseInt(s));
        }
        return resutList;
    }

    public static String doubless(String text) {
        String[] strings = text.split(" ");
        Set<String> nonDublesSet = new LinkedHashSet<>();
        List<String> duplicates = new LinkedList<>();
        for (String string : strings) {
            if (!nonDublesSet.contains(string)) {
                duplicates.add(string);
            } else {
                nonDublesSet.add(string);
            }
        }
        System.out.println(duplicates);
        System.out.println(nonDublesSet);
        return duplicates.stream().collect(Collectors.joining(" "));
    }

    public static String even(String numbers) {
        String[] even = numbers.split(" ");
        StringBuilder result = new StringBuilder();
        for (String s : even){
            if(Integer.parseInt(s)%4 == 0) {
                result.append(s+" ");
            }
        }
        return result.toString();
    }

    public static double avg(List<Integer> someNumbers) {
        return someNumbers.stream()
                .mapToInt(t->t)
                .average()
                .orElse(0);
    }

    public static long maxFromLst(List<Integer> nunmbers) {
        return nunmbers.stream()
                .mapToInt(t->t)
                .sum();
    }

    public static List<String> streamDisc(List<String> texty) {
        return texty.stream()
                .distinct()
                .collect(Collectors.toList());

    }


}
