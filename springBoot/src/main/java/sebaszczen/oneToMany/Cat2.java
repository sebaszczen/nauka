package sebaszczen.oneToMany;

import sebaszczen.beanUtils.Mouse;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cat2 {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int age;

    public Cat2(Mouse mouse, String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Cat2() {

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
                "mouse="  +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
