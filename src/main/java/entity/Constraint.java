package entity;

import enums.ConstraintType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Constraint {

    @Id
    private Integer id;

    private Set<Field> fields;

    private ConstraintType constraintType;

    @ManyToMany
    @JoinTable(name = "scenario_constraints"
            , joinColumns = {@JoinColumn(name="scenario_id")
            }
            ,inverseJoinColumns = {@JoinColumn(name="constraint_id")})
    private Scenario scenario;

    @ManyToMany(mappedBy = "constraints")
    private Set<Action> actions;


    private String fieldValues;

}
