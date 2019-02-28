package pl.basic.dziedziczenie;

public class Programmer extends  Writer {

    private int x = 1;

    Programmer(int x){
        this.x = x;
        System.out.println("programmer constructor super " + x);
    }

    public void programing(){
        System.out.println("programmer is programing");
    }

    @Override
    public void write() {
        System.out.println("programmer write....");
    }

    @Override
    public void swin() {

    }

    @Override
    public void jogging() {
        System.out.println("programmer is jogging");
    }

    @Override
    public void ridingbike() {

    }
}
