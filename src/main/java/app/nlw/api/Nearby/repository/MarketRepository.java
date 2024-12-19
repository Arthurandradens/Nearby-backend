package app.nlw.api.Nearby.repository;

import app.nlw.api.Nearby.model.Market;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MarketRepository extends JpaRepository<Market, UUID> {
    List<Market> findAllByCategoryId(UUID categoryId);

}
