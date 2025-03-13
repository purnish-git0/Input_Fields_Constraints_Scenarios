package rules.action;


import rules.entity.Field;

import java.util.List;

public class ConstraintContext {

    public ConstraintStrategy constraintStrategy;

    public ConstraintContext(ConstraintStrategy constraintStrategy) {
        this.constraintStrategy = constraintStrategy;

    }


    public void performConstraint(Field f, List<String> args) {
        this.constraintStrategy.applyConstraint(f, args);
    }
}
