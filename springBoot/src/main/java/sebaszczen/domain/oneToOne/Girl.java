package sebaszczen.domain.oneToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Girl {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sekwencja")
    private Long id;


}
