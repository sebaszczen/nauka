package sebaszczen.unittesting.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sebaszczen.unittesting.spring.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer > {
}
