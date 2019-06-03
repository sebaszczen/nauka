package maciek.pl.threads.authorsWriters;

public class Article {
    String text;
    boolean isNewText = false;


    synchronized void setTextToWrite(String s) {
        while (isNewText == true) {
            //robimy wait aby przerwac watek aby writer nie odczytał złego tekstu (za wczesnie)
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        text = s;
        isNewText = true;
        notifyAll();
    }

    synchronized String getTextToWriter() {
        while (isNewText == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Thread process stopped");
            }
        }
        isNewText = false;
        notifyAll();
        return text;
    }
}
