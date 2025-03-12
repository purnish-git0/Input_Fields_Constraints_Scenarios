package service;

import entity.Constraint;
import entity.Field;
import entity.Scenario;
import lombok.Data;
import repository.FieldRepository;
import repository.ScenarioRepository;

import java.util.Map;
import java.util.Set;

@Data
public class ScenarioCreateService {



    private Set<Field> fieldsInScenario;

    private ScenarioRepository scenarioRepository;

    private FieldRepository fieldRepository;

    public ScenarioCreateService(ScenarioRepository scenarioRepository,
                                 FieldRepository fieldRepository) {
        this.scenarioRepository = scenarioRepository;

        this.fieldRepository = fieldRepository;

    }

    public String createPossibleValuesOfFieldInScenario(Integer fieldId, Integer scenarioId,
                                                        String possibleValues) {

        Scenario scenario = scenarioRepository.findByTargetFieldId(fieldId).get();

        scenario.setPossibleValues(possibleValues);

        scenarioRepository.save(scenario);

        return scenario.getPossibleValues();

    }

    public void mapScenarioToField(Integer fieldId, Integer scenarioId) {
        Scenario scenario = scenarioRepository.findById(scenarioId).get();
        Field field = fieldRepository.findById(fieldId).get();
        scenario.getFields().add(field);
        scenarioRepository.save(scenario);
    }


}
