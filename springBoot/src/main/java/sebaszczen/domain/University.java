package sebaszczen.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class University {

    @Id
    private Long id;

    private String name;
    @OneToMany(  mappedBy = "university")
    private List<Student>studentList;

    public University(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public University() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
