package sebaszczen.oneToMany;

import org.hibernate.annotations.Generated;
import sebaszczen.beanUtils.Mouse;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cat {
    @Id
    @GeneratedValue
    private Long id;

    String name;

    public Cat(Mouse mouse, String name) {
        this.name = name;
    }

    public Cat() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
