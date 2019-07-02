package sebaszczen.mongodb.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Player {

    @Id
    private String login;
    private String passwordHash;
    private String email;

    public Player(String login) {
        this.login = login;
    }
}
