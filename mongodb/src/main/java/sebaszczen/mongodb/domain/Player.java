package sebaszczen.mongodb.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Player {

    @Id
    private String login;
    private String passwordHash;
    private String email;
    private int age;

    public Player(String login, String passwordHash, String email, int age) {
        this.login = login;
        this.passwordHash = passwordHash;
        this.email = email;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Player{" +
                "login='" + login + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getLogin() {
        return login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}
