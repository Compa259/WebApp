package masjav.nmd.spring.repository;

import masjav.nmd.spring.model.ItemCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemCategoryRepository extends CrudRepository<ItemCategory, Long> {

    @Query(value = "SELECT * FROM item_category WHERE category_id = ?1", nativeQuery = true)
    List<ItemCategory> findByCategoryId(Long id);
}
