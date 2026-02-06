package com.ecom.productcatalog.controller;

import com.ecom.productcatalog.Service.CategoryService;
import com.ecom.productcatalog.model.Category;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:5173")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getallCategories() {
        return categoryService.getAllCategories();
    }
}
