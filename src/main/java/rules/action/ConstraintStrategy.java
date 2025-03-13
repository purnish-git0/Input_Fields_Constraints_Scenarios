package rules.action;

import rules.entity.Field;

import java.util.List;

public interface ConstraintStrategy {

    public void applyConstraint(Field field, List<String> args);
}
