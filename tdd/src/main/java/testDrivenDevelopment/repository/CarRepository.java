package testDrivenDevelopment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import testDrivenDevelopment.domain.Car;

@Repository
public interface CarRepository extends CrudRepository<Car,Long> {
    Car findByName(String prius);
}
