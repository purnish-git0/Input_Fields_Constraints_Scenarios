package rules.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
public class ActionOutcome {

    @Id
    private Integer id;

    @OneToOne(mappedBy = "actionOutcome")
    private Action action;
}
