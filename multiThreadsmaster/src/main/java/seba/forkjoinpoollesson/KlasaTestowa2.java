package seba.forkjoinpoollesson;

public class KlasaTestowa2 extends ForkJoinPoolLesson{

        private String name = super.name;

        private ForkJoinPoolLesson forkJoinPoolLesson = new ForkJoinPoolLesson();

        public String xx() {
            return super.getName();
        }


        public static void main(String[] args) {
            KlasaTestowa2 klasaTestowa = new KlasaTestowa2();
            System.out.println(klasaTestowa.xx());
            ForkJoinPoolLesson forkJoinPoolLesson = new ForkJoinPoolLesson();

            System.out.println(klasaTestowa.name);
            klasaTestowa.new Wewnetrzna();
        }

        class Wewnetrzna {
            String age = "2";
        }

    }
