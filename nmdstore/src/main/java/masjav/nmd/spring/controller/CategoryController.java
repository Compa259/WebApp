package masjav.nmd.spring.controller;

import masjav.nmd.spring.model.Category;
import masjav.nmd.spring.model.ItemCategory;
import masjav.nmd.spring.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/category")
    public List<Category> getAllCaterory() {
        return (List<Category>) categoryService.getAllCategory();
    }

    @RequestMapping("/category/{id}")
    public Category getCategoryById(@PathVariable("id") long id) {
        return (Category) categoryService.findCategoryById(id);
    }

}
