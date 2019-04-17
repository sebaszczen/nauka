package sebaszczen.beanUtils;

public class Cat {
    Mouse mouse;
    String name;

    public Cat(Mouse mouse, String name) {
        this.mouse = mouse;
        this.name = name;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
