package sebaszczen.unittesting.spring.controller;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//spring boot test bedzie szukac w katalogu sebaszczen.unittesting.spring.controller adnotacji @SpringApplication
//jesli jej nie znajdzie to bedzie przegladac wyzsze pakiety - w rezultacie stworzy cala aplikacje oraz in memory database
//zaladuje rowniaz dane w pliku .sql z katalogów resources
//random port- mamy pewnosc ze przy continuous integration, nasz test nie wywali sie przez to ze inny test juz idzie na jakims porcie
@TestPropertySource(locations = {"classpath:test-configuration.properties"})
public class ItemControllerIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void allItemsFromDatabase() throws JSONException {
        String forObject = testRestTemplate.getForObject("/all-items-from-database", String.class);
        JSONAssert.assertEquals("[{id:2,name:'item2',price:22,quantity:222},{id:3,name:'item2',price:22,quantity:222}]",forObject,false);
    }
}