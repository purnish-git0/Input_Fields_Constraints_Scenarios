

import entity.Field;

import java.util.List;

public interface RuleDictionary {


    public List<Rule> getRuleFor(Field field);

    public FieldContext getContextFor(Field field);
}
