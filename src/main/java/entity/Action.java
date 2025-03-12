package entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Action {

    @Id
    private Integer id;

    private Field field;

    @ManyToMany
    @JoinTable(name = "action_constraints", joinColumns = @JoinColumn(name = "constraint_id"),
            inverseJoinColumns = @JoinColumn(referencedColumnName = "id"))

    private Set<Constraint> constraints;

    @OneToOne
    @JoinColumn(name = "action_outcome_id")
    private ActionOutcome actionOutcome;

}
