package sebaszczen.DependencyInjection1.components;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "comp")
@Scope(scopeName = "prototype")
public class Computer {
    String name;

    public Computer() {
        System.out.println("computer created");
    }

    public void comppile() {
        System.out.println("compiling");
    }
}
