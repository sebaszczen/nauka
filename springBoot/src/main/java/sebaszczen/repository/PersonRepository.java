package sebaszczen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sebaszczen.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
