package sebaszczen.manyToOneUnidirectional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class House {

    @Id
//    @GeneratedValue
    private Long id;

    private String houseName;

    public House() {
    }

    public House(String houseName) {
        this.houseName = houseName;
    }
}
