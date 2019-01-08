package testDrivenDevelopment.unitTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import testDrivenDevelopment.domain.Car;
import testDrivenDevelopment.exceptions.CarNotFoundException;
import testDrivenDevelopment.repository.CarRepository;
import testDrivenDevelopment.service.CarService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    private CarService carService;

    @Before
    public void getCarDetails_returnsCarInfo() {
        carService = new CarService(carRepository);
    }

    @Test
    public void getCarDetails_returnCarInfo() {
        given(carRepository.findByName("prius")).willReturn(new Car("prius", "hybrid"));
        Car car = carService.getCarDetails("prius");
        assertThat(car.getName()).isEqualTo("prius");
        assertThat(car.getType()).isEqualTo("hybrid");
    }

    @Test(expected = CarNotFoundException.class)
    public void getCarDetails_whenCarNotFound() {
        given(carRepository.findByName("prius")).willReturn(null);
        carService.getCarDetails("prius");
    }
}
