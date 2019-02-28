package pl.basic;

public class StringBasic {

    public static void main(String[] args) {
//        String basic1String = "J3edz65ie k1ot0ek przez pl2otek";
//        String onlyNumbers = basic1String.substring(11);
//        System.out.println(onlyNumbers);
//
//        String onlyMach = onlyNumbers.replaceAll("[0-9]+", "");
//        System.out.println(onlyMach);

//        LinkedList<Integer> listOfN = new LinkedList<>();
//        listOfN.add(1);
//        listOfN.add(2);
//        listOfN.add(13);
//        listOfN.add(14);
//        listOfN.add(111);
//
//        List<Integer> arrayListI = new ArrayList<>();
//        arrayListI.add(1);
//        arrayListI.add(12);
//        arrayListI.add(122);
//        arrayListI.add(142);
//        arrayListI.add(155);
//
//        Iterator<Integer> iterator = listOfN.iterator();
//        while (iterator.hasNext()) {
//            Integer exam = iterator.next();

        System.out.println(pere(2));
    }

    public static int pere(long n) {
        int result = 0;

        String number = String.valueOf(n);
        if(number.length()>1) {
            result =1;
        }

        return result;
    }
}




