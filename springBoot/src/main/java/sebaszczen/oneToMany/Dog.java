package sebaszczen.oneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
public class Dog {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Fetch(value = FetchMode.JOIN)
    private List<Owner> ownerList;

    public Dog(List<Owner> ownerList,String name) {
        this.ownerList = ownerList;
        this.name = name;
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
