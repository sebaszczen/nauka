package sebaszczen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sebaszczen.domain.Car;

public interface CarRepository extends JpaRepository<Car,Long> {
}
