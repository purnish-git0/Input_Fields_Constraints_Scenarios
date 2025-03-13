package rules.entity;

import lombok.experimental.SuperBuilder;
import rules.enums.ConstraintType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@SuperBuilder
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ConstraintEntity {

    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "field_id")
    private Field field;

    private ConstraintType constraintType;

    @ManyToOne
    @JoinColumn(name = "scenario_id")
    private Scenario scenario;

    @ManyToMany(mappedBy = "constraints")
    private Set<Action> actions;


    private String fieldValues;

}
