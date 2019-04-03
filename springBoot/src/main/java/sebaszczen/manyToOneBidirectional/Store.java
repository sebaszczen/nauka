package sebaszczen.manyToOneBidirectional;




import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "store")
//    @JoinColumn
    private Set<Products> productsSet;

    public Store(Set<Products> productsSet) {
        this.productsSet = productsSet;
    }

    public Store() {
    }
}
