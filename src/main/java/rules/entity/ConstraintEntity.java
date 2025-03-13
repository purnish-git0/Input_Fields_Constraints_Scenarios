package rules.entity;

import rules.enums.ConstraintType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
public class ConstraintEntity {

    @Id
    private Integer id;

    @ManyToMany(mappedBy = "constraints")
    private Set<Field> fields;

    private ConstraintType constraintType;

    @ManyToOne
    @JoinColumn(name = "scenario_id")
    private Scenario scenario;

    @ManyToMany(mappedBy = "constraints")
    private Set<Action> actions;


    private String fieldValues;

}
