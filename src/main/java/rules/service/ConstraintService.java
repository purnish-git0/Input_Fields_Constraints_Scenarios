package rules.service;

import rules.ConstraintStrategyFactory;
import rules.action.ConstraintStrategy;
import rules.action.EqualsConstraintStrategy;
import rules.entity.ConstraintEntity;
import rules.entity.Field;
import rules.entity.Scenario;
import rules.enums.ConstraintType;
import org.springframework.stereotype.Service;
import rules.enums.StrategyNames;
import rules.repository.ConstraintRepository;
import rules.repository.FieldRepository;
import rules.repository.ScenarioRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ConstraintService {

    private ConstraintRepository constraintRepository;

    private FieldRepository fieldRepository;

    private ScenarioRepository scenarioRepository;

    private ConstraintStrategyFactory strategyFactory;


    public ConstraintService(ConstraintRepository constraintRepository,
                             FieldRepository fieldRepository,
                             ScenarioRepository scenarioRepository,
                             ConstraintStrategyFactory strategyFactory) {
        this.constraintRepository = constraintRepository;
        this.fieldRepository = fieldRepository;
        this.scenarioRepository = scenarioRepository;
        this.strategyFactory = strategyFactory;
    }


    public void createConstraint(Integer fieldId, ConstraintType constraintType, List<String> args) {
        Field f = fieldRepository.findById(fieldId).get();
        ConstraintEntity constraint = ConstraintEntity.builder()
                .constraintType(constraintType)
                .build();
        ConstraintStrategy strategy = null;
        if(constraintType.equals(ConstraintType.EQUALS)) {
            strategy = strategyFactory.getStrategy(StrategyNames.EQUALS_STRATEGY);
        }
        if(constraintType.equals(ConstraintType.MIN_MAX)) {
            strategy = strategyFactory.getStrategy(StrategyNames.MINMAX_STRATEGY);
        }
        strategy.applyConstraint(f, args);
        constraintRepository.save(constraint);
        Scenario scenario = scenarioRepository
                .findByTargetFieldId(fieldId)
                .get();

        scenario.getConstraints().add(constraint);

        scenarioRepository.save(scenario);



    }

    public Scenario createScenarioFromConstraints(Set<Integer> constraintIds) {
        Scenario scenario = Scenario.builder()
                .constraints(constraintIds.stream().map(constraintId -> {
                    return constraintRepository.findById(constraintId).get();
                }).collect(Collectors.toSet()))
                .build();

        scenarioRepository.save(scenario);

        return scenario;
    }





}
