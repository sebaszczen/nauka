package sebaszczen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sebaszczen.manyToOneUnidirectional.House;

@Repository
public interface HouseRepository extends JpaRepository<House,Long> {
}
