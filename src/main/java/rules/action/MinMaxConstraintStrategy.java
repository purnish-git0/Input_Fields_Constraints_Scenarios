package rules.action;

import rules.entity.Field;
import rules.entity.MinMaxConstraint;
import rules.repository.ConstraintRepository;

import java.util.List;

public class MinMaxConstraintStrategy implements ConstraintStrategy{

    private ConstraintRepository constraintRepository;

    public MinMaxConstraintStrategy(ConstraintRepository constraintRepository) {
        this.constraintRepository = constraintRepository;
    }



    @Override
    public void applyConstraint(Field field, List<String> args) {
        MinMaxConstraint constraint = MinMaxConstraint.builder()
                .minVal(args.get(0))
                .maxVal(args.get(1))
                .field(field)
                .build();

        constraintRepository.save(constraint);

    }
}
