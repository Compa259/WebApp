package masjav.nmd.spring.repository;

import masjav.nmd.spring.model.Product.ProductEAVLong;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductEAVLongRepository extends CrudRepository<ProductEAVLong, Long> {
    @Query(value = "select * from product_eav_long where product_id = ?", nativeQuery = true)
    List<ProductEAVLong> getByProductId(Long id);
}
