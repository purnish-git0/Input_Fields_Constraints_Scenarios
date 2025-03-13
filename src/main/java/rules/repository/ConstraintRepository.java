package rules.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rules.entity.ConstraintEntity;

@Repository
public interface ConstraintRepository extends JpaRepository<ConstraintEntity, Integer> {




}
