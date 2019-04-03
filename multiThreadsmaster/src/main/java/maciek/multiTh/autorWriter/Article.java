package maciek.multiTh.autorWriter;

public class Article {
    private String text;
    private boolean isNewText = false;

    public synchronized void setTextToWrite(String s) {
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

    public synchronized String getTextToWriter() {
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

