package multiTh.autorWriter;

import java.util.Optional;

import static multiTh.Consoler.ANSI_BLUE;
import static multiTh.Consoler.ANSI_RESET;

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
                System.out.println(ANSI_BLUE + "Author has prepared text-> " + words[i] + ANSI_RESET);
            }
            article.setTextToWrite(words[i]);
        }
    }
}