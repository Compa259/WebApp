package masjav.nmd.spring.controller;

import masjav.nmd.spring.model.ItemCategory;
import masjav.nmd.spring.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ItemCategoryController {
    @Autowired
    ItemCategoryService itemCategoryService;

    @RequestMapping("/category/{id}/allitemcategory")
    public List<ItemCategory> getItemCategoryByCategoryId(@PathVariable("id") long id) {
        return itemCategoryService.findByCategoryId(id);
    }
}
