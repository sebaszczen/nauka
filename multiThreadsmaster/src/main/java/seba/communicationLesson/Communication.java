package seba.communicationLesson;

public class Communication {

    static class Data{

        private String title=null;

        public synchronized void writte(String title) throws InterruptedException {
            while (title!=null) {
                wait();
            }
            this.title = title;
            notify();
        }

        public synchronized String read() throws InterruptedException {
            while (title==null){
                wait();
            }
            String tmp = title;
            title = null;
            notify();
            return tmp;
        }
    }
}
