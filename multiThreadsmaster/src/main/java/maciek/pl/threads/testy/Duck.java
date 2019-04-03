package maciek.pl.threads.testy;

public class Duck implements Rideable {
    int weight = 2;
    @Override
    public String getRid() {
        return " string rid";
    }

   public void go (int speed) {
        ++speed;
        weight++;
        int walk = speed*weight;
        System.out.println(walk + getRid());
    }
}
