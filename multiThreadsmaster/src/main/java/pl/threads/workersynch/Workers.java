package pl.threads.workersynch;

public class Workers extends Thread {
    private String text;
    private Message message;

    public Workers(String name, String text, Message message){
        super(name);
        this.text = text;
        this.message = message;
    }

    @Override
    public void run(){
        message.message(text);
    }
}

