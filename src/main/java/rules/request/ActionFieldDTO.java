package rules.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class ActionFieldDTO {

    private Integer fieldId;

    private Integer actionId;
}
