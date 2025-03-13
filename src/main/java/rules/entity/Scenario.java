package rules.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Set;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
public class Scenario {

    @Id
    private Integer id;

    @OneToMany(mappedBy = "scenario")
    private Set<Field> fields;

    @OneToMany(mappedBy = "scenario")
    private Set<ConstraintEntity> constraints;

    private Integer targetFieldId;


    private String possibleValues;

    private String description;

}
