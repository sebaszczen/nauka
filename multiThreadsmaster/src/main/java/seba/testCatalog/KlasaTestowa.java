package seba.testCatalog;

import seba.forkjoinpoollesson.ForkJoinPoolLesson;

import java.util.Arrays;

public class KlasaTestowa extends ForkJoinPoolLesson {

    private String name = super.name;

    private ForkJoinPoolLesson forkJoinPoolLesson = new ForkJoinPoolLesson();

    public String xx() {
        return super.getName();
    }


    public static void main(String[] args) {
        KlasaTestowa klasaTestowa = new KlasaTestowa();
        System.out.println(klasaTestowa.xx());
        ForkJoinPoolLesson forkJoinPoolLesson = new ForkJoinPoolLesson();

        System.out.println(klasaTestowa.name);
        klasaTestowa.new Wewnetrzna();
    }

    class Wewnetrzna {
        String age = "2";
    }

}
