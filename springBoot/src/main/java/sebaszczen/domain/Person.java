package sebaszczen.domain;

import javax.persistence.*;

@Entity
public class Person {

    @Id
//    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
//    @JoinTable(name = "dept_emp_uni_join",
//            joinColumns = @JoinColumn(name = "car_id"),
//            inverseJoinColumns = @JoinColumn(name = "person_id"))
    private Car newCar;

    @ManyToOne
    private Car oldCar;

    public Person() {
    }

    public Person(String name, Car newCar, Car oldCar) {
        this.name = name;
        this.newCar = newCar;
        this.oldCar=oldCar;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String person3, Car newCar2) {
        this.name = person3;
        this.newCar = newCar2;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getNewCar() {
        return newCar;
    }

    public void setNewCar(Car newCar) {
        this.newCar = newCar;
    }

    public String getName() {
        return name;
    }

}
