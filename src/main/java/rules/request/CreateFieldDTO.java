package rules.request;

import lombok.*;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class CreateFieldDTO {

    private Integer fieldId;

    private String name;

    private String fieldType;

    private String description;
}
