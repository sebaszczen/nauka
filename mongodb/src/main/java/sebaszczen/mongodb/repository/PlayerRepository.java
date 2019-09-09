package sebaszczen.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import sebaszczen.mongodb.domain.Player;

public interface PlayerRepository extends MongoRepository<Player,String> {

    public Player findPlayerByEmail(String email);

}
