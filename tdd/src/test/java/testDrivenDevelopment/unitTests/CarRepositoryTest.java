package testDrivenDevelopment.unitTests;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import testDrivenDevelopment.domain.Car;
import testDrivenDevelopment.repository.CarRepository;

import static org.junit.Assert.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void gatCar_returnsCarDeteils() {
        Car savedCar = testEntityManager.persistFlushFind(new Car("prius", "hybrid"));
        Car car =this.carRepository.findByName("prius");
        Assertions.assertThat(car.getName()).isEqualTo(savedCar.getName());
        Assertions.assertThat(car.getType()).isEqualTo(savedCar.getType());
    }
}