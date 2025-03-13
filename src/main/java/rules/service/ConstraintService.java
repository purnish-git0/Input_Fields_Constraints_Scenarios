package rules.service;

import rules.entity.ConstraintEntity;
import rules.entity.Field;
import rules.entity.Scenario;
import rules.enums.ConstraintType;
import org.springframework.stereotype.Service;
import rules.repository.ConstraintRepository;
import rules.repository.FieldRepository;
import rules.repository.ScenarioRepository;

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
        ConstraintEntity constraint = ConstraintEntity.builder()
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
