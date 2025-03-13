package rules.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rules.request.CreateConstraintDTO;
import rules.service.ConstraintService;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/constraint")
public class ConstraintController {


    private ConstraintService constraintService;

    public ConstraintController(ConstraintService constraintService) {
        this.constraintService = constraintService;
    }


    public ResponseEntity<String> createConstraint(@RequestBody CreateConstraintDTO createConstraintDTO) {
        constraintService.createConstraint(createConstraintDTO.getFieldId(), createConstraintDTO.getConstraintType(), createConstraintDTO.getArgs());
        return ResponseEntity.ok("done");
    }

    public ResponseEntity<String> createScenarioFromConstraints(@RequestBody Set<Integer> constraints) {

    }


}

