package sebaszczen.domain.oneToOne.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sebaszczen.domain.oneToOne.Man;

public interface ManRepository extends JpaRepository<Man,Long> {
}
