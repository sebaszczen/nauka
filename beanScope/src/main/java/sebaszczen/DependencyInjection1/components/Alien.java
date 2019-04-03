package sebaszczen.DependencyInjection1.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Alien {

    private String name;
    @Autowired
    @Qualifier(value = "comp")
    private Computer computer;

    public Alien() {
        System.out.println("alien bean created");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getHello() {
        System.out.println("hello alien");
        computer.comppile();
    }
}
