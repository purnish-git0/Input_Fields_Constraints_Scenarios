package rules.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Data
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String key;

    private String value;

    private String fieldType;

    private String description;

    @ManyToMany
    @JoinTable(name = "field_constraints", joinColumns = @JoinColumn(name = "constraint_entity_id"),
    inverseJoinColumns = @JoinColumn(referencedColumnName = "id"))
    private Set<ConstraintEntity> constraints;

    @ManyToOne
    @JoinColumn(name = "scenario_id")
    private Scenario scenario;

}
