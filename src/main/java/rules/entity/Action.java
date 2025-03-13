package rules.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
public class Action {

    @Id
    private Integer id;

    @ManyToMany
    @JoinTable(name = "action_fields", joinColumns = @JoinColumn(name = "field_id"),
            inverseJoinColumns = @JoinColumn(referencedColumnName = "id"))

    private Set<Field> fields;

    @ManyToMany
    @JoinTable(name = "action_constraints", joinColumns = @JoinColumn(name = "constraint_id"),
            inverseJoinColumns = @JoinColumn(referencedColumnName = "id"))

    private Set<ConstraintEntity> constraints;

    @OneToOne
    @JoinColumn(name = "action_outcome_id")
    private ActionOutcome actionOutcome;

}
