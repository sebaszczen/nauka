package sebaszczen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sebaszczen.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
}
