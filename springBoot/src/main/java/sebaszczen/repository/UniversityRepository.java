package sebaszczen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sebaszczen.domain.University;

public interface UniversityRepository extends JpaRepository<University,Long> {
}
