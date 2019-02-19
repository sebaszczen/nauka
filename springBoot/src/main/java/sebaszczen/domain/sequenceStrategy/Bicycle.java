package sebaszczen.domain.sequenceStrategy;

import javax.persistence.*;

@Entity
public class Bicycle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sekwencja")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sekwencja")
    @SequenceGenerator(name = "sekwencja", sequenceName = "moja")
    private Long Id;
}
