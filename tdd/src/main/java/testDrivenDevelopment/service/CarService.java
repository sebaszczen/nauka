package testDrivenDevelopment.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import testDrivenDevelopment.domain.Car;
import testDrivenDevelopment.exceptions.CarNotFoundException;
import testDrivenDevelopment.repository.CarRepository;

@Service
public class CarService {
    private String carDetails;
    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Cacheable("cars")
    public Car getCarDetails(String name) {
        Car car = carRepository.findByName(name);
        if (car == null) {
            throw new CarNotFoundException();
        }
        return car;
    }
}
