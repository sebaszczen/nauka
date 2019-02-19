package sebaszczen.domain.sequenceStrategy;

import javax.persistence.*;

@Entity
public class Wheel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sekwencja")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sekwencja")
//    @SequenceGenerator(sequenceName = "mojaSekwencja", name = "sekwencja")
    private Long Id;
}
