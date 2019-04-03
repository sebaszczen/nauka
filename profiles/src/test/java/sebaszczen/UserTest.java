package sebaszczen;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import sebaszczen.repository.UserRepository;
import sebaszczen.service.PersonService;
import sebaszczen.service.UserService;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
//@SpringBootTest
@ContextConfiguration(classes = {UserService.class,PersonService.class})
@ActiveProfiles("profile2")
public class UserTest {

//    @Autowired
//    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Autowired
    private PersonService personService;

    @Test
    public void saveUser() {
        User user = new User();
        userService.hello();
//        userRepository.save(user);
    }
}