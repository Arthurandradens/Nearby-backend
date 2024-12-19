package app.nlw.api.Nearby.service;

import app.nlw.api.Nearby.dto.CategoryRequest;
import app.nlw.api.Nearby.model.Category;
import app.nlw.api.Nearby.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository repository;
    public void createCategory(CategoryRequest request) {
        try {
            var category = new Category(request);
            repository.save(category);
        }catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }
    }

    public List<Category> getCategories() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }
}
