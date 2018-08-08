package masjav.nmd.spring.repository;

import masjav.nmd.spring.model.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {
    Item findById(Long id);

    List<Item> findByStatus(String status);

    @Query(value = "SELECT * from item \n" +
            "WHERE date_imported >= date_sub(curdate(), INTERVAL 30 DAY)\n" +
            "AND date_imported <= curdate()", nativeQuery=true)
    List<Item> findByNew();
}
