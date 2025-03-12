package entity;

import jakarta.persistence.OneToOne;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class ActionOutcome {



    private Integer id;

    @OneToOne(mappedBy = "actionOutcome")
    private Action action;
}
