package masjav.nmd.spring.controller;

import masjav.nmd.spring.model.Category.Category;
import masjav.nmd.spring.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "/categories/{id}")
    public Category getCategoryById(@PathVariable("id") Long id){
        return categoryService.getCategoryById(id);
    }

    @PostMapping(value = "/categories")
    public Category saveCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }

    @GetMapping(value = "/categories/{id}/subcategories")
    public List<Category> getByParentId(@PathVariable Long id){
        return categoryService.getByParentId(id);
    }
}
