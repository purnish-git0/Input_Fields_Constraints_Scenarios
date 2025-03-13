package rules.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class EqualsConstraint extends ConstraintEntity{

    private Integer id;

    private String equalTo;
}
