package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Builder
public class Field {

    @Id
    private Integer id;

    private String key;

    private String value;

    @ManyToOne
    @JoinColumn(name = "scenario_id")
    private Scenario scenario;

}
