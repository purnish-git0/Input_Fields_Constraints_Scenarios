package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Map;
import java.util.Set;

@Data
@Entity
public class Scenario {

    @Id
    private Integer id;

    @OneToMany(mappedBy = "scenario")
    private Set<Field> fields;

    @ManyToMany(mappedBy = "scenario")
    private Set<Constraint> constraints;

    private String possibleValues;

    private String description;

}
