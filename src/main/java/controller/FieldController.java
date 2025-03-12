package controller;

import entity.Field;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.FieldRepository;
import request.CreateFieldDTO;

@RestController
@RequestMapping("/api/v1/field")
public class FieldController {


    private FieldRepository fieldRepository;

    public FieldController(FieldRepository fieldRepository) {
        this.fieldRepository = fieldRepository;
    }

    public ResponseEntity<String> createField(@RequestBody CreateFieldDTO createFieldDTO) {
        Field field = Field.builder()
                .key(createFieldDTO.getName())
                .fieldType(createFieldDTO.getFieldType())
                .description(createFieldDTO.getDescription())
                .build();

        fieldRepository.save(field);

        return ResponseEntity.ok("done");
    }
}
