package rules.entity;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class MinMaxConstraint extends ConstraintEntity{

    private Integer id;

    private String minVal;

    private String maxVal;
}
