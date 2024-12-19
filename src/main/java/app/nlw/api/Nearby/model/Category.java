package app.nlw.api.Nearby.model;

import app.nlw.api.Nearby.dto.CategoryRequest;
import jakarta.persistence.*;

import java.util.UUID;

@Entity(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;

    public Category() {}

    public Category(CategoryRequest request) {
        this.name = request.name();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
