package masjav.nmd.spring.repository;

import masjav.nmd.spring.model.Category;
import org.springframework.data.repository.CrudRepository;


public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findById(Long id);
}
