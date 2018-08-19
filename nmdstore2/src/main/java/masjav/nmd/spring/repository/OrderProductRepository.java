package masjav.nmd.spring.repository;

import masjav.nmd.spring.model.OrderProduct.OrderProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderProductRepository extends CrudRepository<OrderProduct, Long> {
    @Query(value = "SELECT * FROM nmdstore2.`order_product` where order_id in( SELECT id FROM nmdstore2.`order` where customer_id = ?) order by order_id DESC",
                    nativeQuery = true)
    List<OrderProduct> getByOwnerId(Long id);
}
