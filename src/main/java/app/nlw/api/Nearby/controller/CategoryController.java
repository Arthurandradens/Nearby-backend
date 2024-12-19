package app.nlw.api.Nearby.controller;

import app.nlw.api.Nearby.dto.CategoryRequest;
import app.nlw.api.Nearby.model.Category;
import app.nlw.api.Nearby.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategoryService service;


    @GetMapping
    public ResponseEntity<List<Category>> index(){
      var categories = service.getCategories();

      return ResponseEntity.ok(categories);
    }


    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CategoryRequest request){
        service.createCategory(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
