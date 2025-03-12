package entity;

import enums.ConstraintType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Constraint {

    @Id
    private Integer id;

    private ConstraintType constraintType;

    @ManyToMany
    @JoinTable(name = "scenario_constraints"
            , joinColumns = {@JoinColumn(name="scenario_id")
            }
            ,inverseJoinColumns = {@JoinColumn(name="constraint_id")})
    private Scenario scenario;


    private String fieldValues;

}
