package testDrivenDevelopment.unitTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import testDrivenDevelopment.domain.Car;
import testDrivenDevelopment.repository.CarRepository;
import testDrivenDevelopment.service.CarService;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CachingTest {

    @MockBean
    private CarRepository carRepository;

    @Autowired
    private CarService carService;

    @Test
    public void caching() {
        when(carRepository.findByName("prius")).thenReturn(new Car("prius", "hybrid"));
        when(carRepository.findByName("skoda")).thenReturn(new Car("skoda", "sdf"));
        carService.getCarDetails("prius");
        carService.getCarDetails("prius");
        carService.getCarDetails("skoda");
        carService.getCarDetails("skoda");
        verify(carRepository,times(2)).count();
    }
}
