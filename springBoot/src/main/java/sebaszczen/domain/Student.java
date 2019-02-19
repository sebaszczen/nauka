package sebaszczen.domain;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    private Long id;

    private String nazwa;

    @ManyToOne(cascade=CascadeType.ALL)
    private University university;

    public Student(Long id,String nazwa, University university) {
        this.id=id;
        this.nazwa = nazwa;
        this.university = university;
    }

    public Student() {
    }

    public Student(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

}
