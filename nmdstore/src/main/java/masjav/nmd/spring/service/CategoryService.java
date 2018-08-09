package masjav.nmd.spring.service;

import masjav.nmd.spring.model.Category;
import masjav.nmd.spring.model.ItemCategory;
import masjav.nmd.spring.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Transactional
    public List<Category> getAllCategory() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Transactional
    public Category findCategoryById(Long id) {
        return (Category) categoryRepository.findById(id);
    }


}
