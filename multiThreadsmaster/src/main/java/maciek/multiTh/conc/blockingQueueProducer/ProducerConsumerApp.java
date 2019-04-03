package maciek.multiTh.conc.blockingQueueProducer;

import gherkin.lexer.Th;

public class ProducerConsumerApp {

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumerProcessor pCp = new ProducerConsumerProcessor();

        Runnable runnableC1 = () -> pCp.producer("producerek1");
        Thread producerT1 = new Thread(runnableC1);

        Thread producerT2 = new Thread(()-> pCp.producer("producerek2"));

        Runnable runnableC2 = () -> pCp.consumer("consumerek1");
        Thread consumerT1 = new Thread(runnableC2);

        Thread consumerT2 = new Thread(()-> pCp.consumer("consumerek2"));
        Thread consumerT3 = new Thread(()-> pCp.consumer("consumerek3"));

        producerT2.start();
        producerT1.start();
        consumerT1.start();
//        consumerT3.start();

        producerT1.join();
        producerT2.join();
        consumerT1.join();
//        consumerT3.join();
    }
}
