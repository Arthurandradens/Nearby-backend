package app.nlw.api.Nearby.repository;

import app.nlw.api.Nearby.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {

}
