package pl.threads.calculation;

import java.util.stream.IntStream;

public class Calculation extends Thread {
    int total = 0;
    @Override
    public void run() {
        synchronized (this){
            IntStream.range(0,1000).forEach(c-> total+=c);
            //dostaje notyfikacje po skonczonej pracy i tamten główny co jest wait wstaje i wyswietla kolejny tekst
            // z sysouta
            notify();
        }
    }
}
