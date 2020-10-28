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
    private IdCard idCard;

    public Player(String login, String passwordHash, String email, int age, IdCard idCard) {
        this.login = login;
        this.passwordHash = passwordHash;
        this.email = email;
        this.age = age;
        this.idCard = idCard;
    }

    public Player() {

    }

    @Override
    public String toString() {
        return "Player{" +
                "login='" + login + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", idCard=" + idCard +
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

    public class IdCard{
        private int number;
        private String color;

        public IdCard(int number, String color) {
            this.number = number;
            this.color = color;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        @Override
        public String toString() {
            return "IdCard{" +
                    "number=" + number +
                    ", color='" + color + '\'' +
                    '}';
        }
    }
}
