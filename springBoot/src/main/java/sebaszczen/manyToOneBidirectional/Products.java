package sebaszczen.manyToOneBidirectional;

import javax.persistence.*;

@Entity
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name="storeid")
//    private Store store;

//    public void setStore(Store store) {
//        this.store = store;
//    }

    public Products() {
    }
}
