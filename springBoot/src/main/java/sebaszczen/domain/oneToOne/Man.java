package sebaszczen.domain.oneToOne;

import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;

@Entity
public class Man {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sekwencja")
    private Long id;

//    @MapsId
    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "xxxx")
    private Girl girl;

    public Man(Girl girl) {
        this.girl = girl;
    }

    public Man(Long id) {
        this.id = id;
    }

    public Man() {

    }

    public Girl getGirl() {
        return girl;
    }
}
