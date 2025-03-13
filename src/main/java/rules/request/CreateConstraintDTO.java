package rules.request;

import rules.enums.ConstraintType;
import lombok.*;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class CreateConstraintDTO {

    private Integer fieldId;

    private ConstraintType constraintType;

    private String description;
}
