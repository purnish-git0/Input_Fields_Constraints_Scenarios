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

    @OneToMany(mappedBy = "field")
    private Set<ConstraintEntity> constraints;

    @ManyToOne
    @JoinColumn(name = "scenario_id")
    private Scenario scenario;

    @ManyToMany(mappedBy = "fields")
    private Set<Action> actions;
}
