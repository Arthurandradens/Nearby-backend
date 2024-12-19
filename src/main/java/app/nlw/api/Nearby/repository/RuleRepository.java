package app.nlw.api.Nearby.repository;

import app.nlw.api.Nearby.model.Rule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RuleRepository extends JpaRepository<Rule, UUID> {
    List<Rule> findAllByMarketId(UUID id);
}
