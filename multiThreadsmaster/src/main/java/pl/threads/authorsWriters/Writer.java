package pl.threads.authorsWriters;

public class Writer extends Thread {

    private Article article;

    public Writer(Article article) {
        this.article = article;
    }

    @Override
    public void run() {
        String text = article.getTextToWriter();
        while (text != null) {
            System.out.println(" Writer is writig a text.. " + text);
            text = article.getTextToWriter();
        }
    }
}
