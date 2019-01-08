package sebaszczen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */

@SpringBootApplication
public class App 
{
    @Autowired
    private static String blue;

    public static void main( String[] args )
    {
        SpringApplication.run(App.class);
        System.out.println(blue);
    }
}
