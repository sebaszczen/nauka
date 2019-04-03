package sebaszczen.DependencyInjection1.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
//lub
//@Scope("singleton")
public class AlienSingleton {

    private String name;

    public AlienSingleton()
    {
        System.out.println("alien singleton created");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
