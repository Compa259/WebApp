package masjav.nmd.spring.repository;

import masjav.nmd.spring.model.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {
    Item findById(Long id);

    //function to get sale items
    List<Item> findByStatus(String status);

    //Query to get new items and mapping with function findByNew
    @Query(value = "SELECT * from item \n" +
            "WHERE date_imported >= date_sub(curdate(), INTERVAL 30 DAY)\n" +
            "AND date_imported <= curdate()", nativeQuery=true)
    List<Item> findByNew();

    //Query to get hot selling items and mapping with function findByTop
    @Query(value = "SELECT * FROM item WHERE id IN (SELECT item_id from (SELECT id,invoice_id, item_id, sum(bought_num) as sum_num" +
            " FROM invoice_item group by item_id" +
            " order by sum_num DESC limit 3) as temp_table)", nativeQuery = true)
    List<Item> findbyTop();

    @Query(value = "SELECT * FROM item WHERE id IN (SELECT item_id from (SELECT id,invoice_id, item_id, sum(bought_num) as sum_num" +
            " FROM invoice_item group by item_id" +
            " order by sum_num DESC limit 3) as temp_table) and item_category_id = ?1", nativeQuery = true)
    List<Item> findByTopFollowItemCategory(Long id);

    @Query("select u from Item u where item_category_id IN (" +
            "SELECT id FROM ItemCategory where category_id = ?1)")
    Page<Item> findAllByCategory(Long id, Pageable pageable);
}
