package es.jllopezalvarez.ejemplos.spring.ejemplo05shop.controllers;

import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.dto.CategoryDto;
import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.dto.CreateCategoryDto;
import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.entities.Category;
import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Obtener todas las categorías
    @GetMapping
    public List<CategoryDto> findAll() {
        return categoryService.findAll().stream().map(this::map).toList();

//        List<CategoryDto> resultados = new ArrayList<>();
//        for(Category category: categoryService.findAll()){
//            resultados.add(map(category));
//        }
//        return resultados;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> findById(@PathVariable(name = "id") Long categoryId) {
        Optional<Category> optCategory = categoryService.findById(categoryId);
        if (optCategory.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(map(optCategory.orElseThrow()));
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long categoryId) {
        if (!categoryService.existsById(categoryId)){
            return ResponseEntity.notFound().build();
        }
        categoryService.deleteById(categoryId);
        return ResponseEntity.ok().build();
    }


    @PostMapping
    public CategoryDto save(@RequestBody CreateCategoryDto dto) {
        // Mapear este CreateCategoryDto a un nuevo Category
        Category newCategory = Category.builder()
                .name(dto.getName())
                .build();

        // Guardar usando el correspondiente método de servicio
        newCategory = categoryService.save(newCategory);

        // Mapear la nueva categoría a DTO y devolverla
        return map(newCategory);

    }


    private CategoryDto map(Category category) {
        return CategoryDto.builder()
                .categoryId(category.getCategoryId())
                .name(category.getName())
                .build();
    }

}
