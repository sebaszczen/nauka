package sebaszczen.mongodb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sebaszczen.mongodb.domain.Player;
import sebaszczen.mongodb.repository.PlayerRepository;

@Service
public class PlayerService {

    @Autowired
    public PlayerRepository playerRepository;

    public void savePlayer(Player player) {
        playerRepository.save(player);
    }

}
