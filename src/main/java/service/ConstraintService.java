package service;

import entity.Constraint;
import entity.Field;
import entity.Scenario;
import enums.ConstraintType;
import org.springframework.stereotype.Service;
import repository.ConstraintRepository;
import repository.FieldRepository;
import repository.ScenarioRepository;

@Service
public class ConstraintService {

    private ConstraintRepository constraintRepository;

    private FieldRepository fieldRepository;

    private ScenarioRepository scenarioRepository;



    public ConstraintService(ConstraintRepository constraintRepository,
                             FieldRepository fieldRepository,
                             ScenarioRepository scenarioRepository) {
        this.constraintRepository = constraintRepository;
        this.fieldRepository = fieldRepository;
        this.scenarioRepository = scenarioRepository;
    }


    public void createConstraint(Integer fieldId, ConstraintType constraintType) {
        Field f = fieldRepository.findById(fieldId).get();
        Constraint constraint = Constraint.builder()
                .constraintType(constraintType)
                .build();
        constraintRepository.save(constraint);
        Scenario scenario = scenarioRepository
                .findByTargetFieldId(fieldId)
                .get();

        scenario.getConstraints().add(constraint);

        scenarioRepository.save(scenario);



    }



}
