package masjav.nmd.spring.repository;

import masjav.nmd.spring.model.Category.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category getById(Long id);

    Category save(Category category);

    @Query(value = "select * from category where parent_id=?", nativeQuery = true)
    List<Category> getByParentId(Long id);
}
