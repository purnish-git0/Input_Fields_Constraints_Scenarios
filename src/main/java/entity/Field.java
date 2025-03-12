package entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Field {

    @Id
    private Integer id;

    private String key;

    private String value;

    private String fieldType;

    private String description;

    @ManyToMany
    @JoinTable(name = "field_constraints", joinColumns = @JoinColumn(name = "constraint_id"),
    inverseJoinColumns = @JoinColumn(referencedColumnName = "id"))
    private Set<Constraint> constraints;

    @ManyToOne
    @JoinColumn(name = "scenario_id")
    private Scenario scenario;

}
