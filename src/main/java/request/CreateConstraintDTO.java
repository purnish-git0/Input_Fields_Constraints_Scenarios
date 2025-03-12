package request;

import enums.ConstraintType;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class CreateConstraintDTO {

    private Integer fieldId;

    private ConstraintType constraintType;

    private String description;
}
