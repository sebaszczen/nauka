package sebaszczen.beanUtils;

public class Cat2 {
    private Mouse mouse;
    private String name;
    private int age;

    public Cat2(Mouse mouse, String name, int age) {
        this.mouse = mouse;
        this.name = name;
        this.age = age;
    }

    public Cat2() {

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat2{" +
                "mouse=" + mouse +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
