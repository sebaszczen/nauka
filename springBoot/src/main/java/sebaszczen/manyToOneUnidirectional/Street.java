package sebaszczen.manyToOneUnidirectional;

import javax.persistence.*;
import java.util.List;

@Entity
public class Street {
    @Id
//    @GeneratedValue
    private Long id;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "street_id")
    private List<House> houseList;

    private String streetName;

    public Street() {
    }

    public Street(List<House> houseList, String streetName) {
        this.houseList = houseList;
        this.streetName = streetName;
    }

    public List<House> getHouseList() {
        return houseList;
    }

    public String getStreetName() {
        return streetName;
    }
}
