package sebaszczen.DependencyInjection1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import sebaszczen.DependencyInjection1.components.Alien;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class   App
{
    public static void main( String[] args )
    {

        ConfigurableApplicationContext run = SpringApplication.run(App.class);

    }
}
