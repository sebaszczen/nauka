package sebaszczen.beanUtils;

public class Mouse {

    private String name;

    public Mouse(String xxx) {
        this.name = xxx;
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "name='" + name + '\'' +
                '}';
    }
}
