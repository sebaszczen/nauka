package sebaszczen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sebaszczen.manyToOneBidirectional.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store,Long> {
}
