package sebaszczen.proxyWlasnyPrzyklad;

public class Car implements Tranport {

    private int passengers=5;

    @Override
    public void speed() {
        System.out.println("predkosc "+200);
    }

    @Override
    public int numberOfPassengers(int number) {
        return number*2;
    }

    public void sayHello() {
        System.out.println("helllo");
    }
}
