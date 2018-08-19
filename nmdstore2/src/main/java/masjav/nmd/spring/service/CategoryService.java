package masjav.nmd.spring.service;

import masjav.nmd.spring.model.Category.Category;
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
    public Category getCategoryById(Long id){
        return categoryRepository.getById(id);
    }

    @Transactional
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Transactional
    public List<Category> getByParentId(Long id) {
        return categoryRepository.getByParentId(id);
    }
}
