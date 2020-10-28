package sebaszczen.decoratorPattern;

public class DarkRoast extends Beverage {

    public DarkRoast() {
        this.description = "dark roast";
    }

    @Override
    public double cost() {
        return 0.90;
    }
}
