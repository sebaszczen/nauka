package sebaszczen.oneToMany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DogRepository extends JpaRepository<Dog,Long> {

    @Query("Select c from Dog c join fetch c.ownerList")
    public List<Dog> findDogs();

    @Query("Select c,o from Dog c join fetch c.ownerList o order by c.id, o.id")
    public List<Dog> findDogs2();

}
