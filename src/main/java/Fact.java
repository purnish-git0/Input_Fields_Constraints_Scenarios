

import lombok.Data;

import java.util.Set;

@Data
public class Fact {

    private Integer fieldId;

    private Set<String> values;
}
