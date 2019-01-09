package sebaszczen;

import com.sun.org.glassfish.gmbal.NameValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sebaszczen.configuration.Person;

/**
 * Hello world!
 *
 */

@SpringBootApplication
public class App implements CommandLineRunner
{
    @Autowired
//    @Qualifier("aaa")
    private Person sdfsdf;

    public static void main( String[] args )
    {
        SpringApplication.run(App.class);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(sdfsdf.getName());
    }
}
