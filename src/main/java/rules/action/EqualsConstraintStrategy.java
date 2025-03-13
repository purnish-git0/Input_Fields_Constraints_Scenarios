package rules.action;

import rules.entity.EqualsConstraint;
import rules.entity.Field;
import rules.repository.ConstraintRepository;

import java.util.List;


public class EqualsConstraintStrategy implements ConstraintStrategy{

    private ConstraintRepository constraintRepository;

    public EqualsConstraintStrategy(ConstraintRepository constraintRepository) {
        this.constraintRepository = constraintRepository;
    }


    @Override
    public void applyConstraint(Field field, List<String> args) {


        EqualsConstraint constraint = EqualsConstraint.builder()
                .equalTo(args.get(0))
                .field(field)
                .build();

        constraintRepository.save(constraint);




    }
}
