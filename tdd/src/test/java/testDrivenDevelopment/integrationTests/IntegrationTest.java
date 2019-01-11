package testDrivenDevelopment.integrationTests;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import testDrivenDevelopment.domain.Car;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)// the same SpringJUnit4ClassRunner.class
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class IntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void getCar_returnCarDetails() throws Exception {

        ResponseEntity<Car> response = testRestTemplate.getForEntity("/cars/prius", Car.class);
        //Assertions comes with SpringbootTest adnotation
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//        Assertions.assertThat(response.getBody().getName()).isEqualTo("prius");
//        Assertions.assertThat(response.getBody().getType()).isEqualTo("hybrid");
    }
}
