package rules.request;

import rules.enums.ConstraintType;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class CreateConstraintDTO {

    private Integer fieldId;

    private ConstraintType constraintType;

    private List<String> args;

    private String description;
}
