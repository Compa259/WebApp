package masjav.nmd.spring.repository;

import masjav.nmd.spring.model.Product.ProductAttribute;
import org.springframework.data.repository.CrudRepository;

public interface ProductAttributeRepository extends CrudRepository<ProductAttribute, Long> {
    ProductAttribute save(ProductAttribute productAttribute);
}
