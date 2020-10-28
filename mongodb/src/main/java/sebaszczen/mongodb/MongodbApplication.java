package sebaszczen.mongodb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import sebaszczen.mongodb.configuration.MongoConfig;
import sebaszczen.mongodb.domain.Player;
import sebaszczen.mongodb.repository.PlayerRepository;
import sebaszczen.mongodb.service.PlayerService;

import java.util.List;


@SpringBootApplication
public class MongodbApplication implements CommandLineRunner {

	@Autowired
	private PlayerService playerService;

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

//	static Logger logger = LoggerFactory.getLogger(MongodbApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MongodbApplication.class, args);


	}


	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 10; i++) {
			playerService.savePlayer(new Player("ciezkilogin"+i,
					"hash"+i,	 "emaail"+i,i*2, new Player().new IdCard(i, "green")));
		}

		playerRepository.findAll().forEach(System.out::println);
//
//		findPlayerByName();
//		documentQueryIs("emaail2");
//		documentQueryRegexEmailEndWith2();
//		documentQueryLtAndGtAge(3, 12);

	}

	private void documentQueryLtAndGtAge(int min, int max) {
		Query query = new Query();
		query.addCriteria(Criteria.where("age").gt(min).lt(max));
		List<Player> players = mongoTemplate.find(query, Player.class);
		for (Player player : players) {
			System.out.println(player.getAge());
		}
	}

	private void documentQueryRegexEmailEndWith2() {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").regex("2$"));
		List<Player> players = mongoTemplate.find(query, Player.class);
		System.out.println(players);
	}

	private void documentQueryIs(String ciezkilogin2) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(ciezkilogin2));
		List<Player> players = mongoTemplate.find(query, Player.class);
		System.out.println(players);
	}

	private void findPlayerByName() {
		System.out.println(playerRepository.findPlayerByEmail("emaail3"));
	}
}
