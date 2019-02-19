package sebaszczen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sebaszczen.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
