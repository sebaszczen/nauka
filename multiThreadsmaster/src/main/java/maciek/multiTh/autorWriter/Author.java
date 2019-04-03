package maciek.multiTh.autorWriter;

import java.util.Optional;


public class Author implements Runnable {

     private Article article;

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
            if(Optional.ofNullable(words[i]).isPresent()) {
            }
            article.setTextToWrite(words[i]);
        }
    }
}