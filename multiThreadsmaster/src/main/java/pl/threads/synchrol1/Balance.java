package pl.threads.synchrol1;

public class Balance {

    private int number = 0;

    public int balanceNumbers() {
        number++;
        number--;
        return number;
    }
}
