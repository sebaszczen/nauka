package sebaszczen.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
//    @Scope("prototype")
    public Person blue() {
        return new Person("xxx");
    }

    @Bean
//    @Scope("prototype")
    public Person red() {
        return new Person("aaa");
    }
}
