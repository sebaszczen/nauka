package sebaszczen.oneToMany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Owner {

    @Id
    @GeneratedValue
    private Long id;

    public Owner() {
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                '}';
    }
}
