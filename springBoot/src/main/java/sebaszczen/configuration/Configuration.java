package sebaszczen.configuration;

import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean(value = "blue")
    public String blue() {
        return "blue";
    }

    @Bean
    public String red() {
        return "red";
    }
}
