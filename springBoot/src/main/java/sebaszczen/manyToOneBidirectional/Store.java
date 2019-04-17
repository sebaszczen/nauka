package sebaszczen.manyToOneBidirectional;




import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn
    private List<Products> productsSet;

    public Store(List<Products> productsSet) {
        this.productsSet = productsSet;
    }

    public Store() {
    }

    public List<Products> getProductsSet() {
        return productsSet;
    }

    public void setProductsSet(List<Products> productsSet) {
        this.productsSet = productsSet;
    }
}
