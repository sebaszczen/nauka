package sebaszczen.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Car {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(fetch = FetchType.EAGER,  mappedBy = "newCar",orphanRemoval = true)
    List<Person> newCar;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "oldCar", orphanRemoval = true)
    List<Person> oldCar;


//    @OneToMany(mappedBy = "car")
//    private List<Person>newCar;

    public Car(long id, String name) {
        this.name = name;
        this.id=id;
    }

    public Car() {
    }

    public List<Person> getNewCar() {
        return newCar;
    }

    public void setNewCar(List<Person> newCar) {
        this.newCar = newCar;
    }

    public List<Person> getOldCar() {
        return oldCar;
    }

    public void setOldCar(List<Person> oldCar) {
        this.oldCar = oldCar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
