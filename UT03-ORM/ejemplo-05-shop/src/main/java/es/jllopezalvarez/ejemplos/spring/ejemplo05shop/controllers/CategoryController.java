package es.jllopezalvarez.ejemplos.spring.ejemplo05shop.controllers;

import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.dto.CategoryDto;
import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.entities.Category;
import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<CategoryDto> findAll() {
        return categoryService.findAll().stream().map(this::map).toList();

//        List<CategoryDto> resultados = new ArrayList<>();
//        for(Category category: categoryService.findAll()){
//            resultados.add(map(category));
//        }
//        return resultados;


    }


    private CategoryDto map(Category category) {
        return CategoryDto.builder()
                .categoryId(category.getCategoryId())
                .name(category.getName())
                .build();
    }

}
