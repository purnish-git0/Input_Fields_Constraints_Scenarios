

import entity.Field;

import java.util.Set;

public interface Rule {


    public FieldValues getFieldValues(Field field);

    FieldValues getFieldValues(Field target, Field depends, Set<String> dependsValues);
}
