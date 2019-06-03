package sebaszczen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import sebaszczen.repository.UserRepository;
import sebaszczen.service.UserService;

import javax.sql.DataSource;


/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App implements CommandLineRunner
{
    @Autowired
    Environment environment;
    @Autowired
    private UserRepository userRepository;

    public static void main( String[] args )

    {
        ConfigurableApplicationContext run = SpringApplication.run(App.class, args);
    }



    public void getActiveProfiles() {
        System.out.println(environment.toString());
        for (final String profileName : this.environment.getActiveProfiles()) {
            System.out.println("Currently active profile - " + profileName);
        }
        userRepository.save(new User());
    }

    @Override
    public void run(String... args) throws Exception {
//        getActiveProfiles();
    }
}
