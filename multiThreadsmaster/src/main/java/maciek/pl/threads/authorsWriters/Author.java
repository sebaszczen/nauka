package maciek.pl.threads.authorsWriters;

public class Author implements Runnable {
     Article article;

     public Author(Article article) {
        this.article = article;
    }

    @Override
    public void run() {
        String[] words = {"Title", "do widzenia", "Hallo", null};
        for(int i = 0; i < words.length; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            article.setTextToWrite(words[i]);
        }
    }
}