package sebaszczen.oneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import sebaszczen.beanUtils.Cat;

import javax.persistence.*;
import java.util.List;

@Entity
public class Dog {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Owner> ownerList;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private sebaszczen.oneToMany.Cat cat;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Cat2 cat2;


    public Dog(List<Owner> ownerList, String name, sebaszczen.oneToMany.Cat cat, Cat2 cat2) {
        this.ownerList = ownerList;
        this.name = name;
        this.cat = cat;
        this.cat2 = cat2;
    }

    public Dog(long l, String sdf) {
        this.id=l;
        this.name = sdf;
    }

    public Dog(long l) {
        this.id = l;
    }

    public Dog() {

    }

    public List<Owner> getOwnerList() {
        return ownerList;
    }

    public void setOwnerList(List<Owner> ownerList) {
        this.ownerList = ownerList;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                '}';
    }
}
