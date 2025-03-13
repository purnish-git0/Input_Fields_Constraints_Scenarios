package rules.repository;

import rules.entity.Scenario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScenarioRepository extends JpaRepository<Scenario, Integer> {

    @Query(value = "select s from Scenario s where s.targetFieldId=:targetFieldId")
    public Optional<Scenario> findByTargetFieldId(Integer targetFieldId);

}
