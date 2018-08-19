package masjav.nmd.spring.repository;

import masjav.nmd.spring.model.Product.ProductEAVVarchar;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductEAVVarcharRepository extends CrudRepository<ProductEAVVarchar, Long> {
    ProductEAVVarchar save(ProductEAVVarchar productEAVVarchar);

    //@Query(value = "select * from product_eav_varchar where product_id = ?", nativeQuery = true)
    @Query(value = "select *\n" +
            "from\n" +
            "(\n" +
            "\tSELECT * \n" +
            "\tFROM nmdstore2.product_eav_varchar as a\n" +
            "\tunion \n" +
            "\tselect * \n" +
            "\tfrom nmdstore2.product_eav_long as b\n" +
            ") as temp_table\n" +
            "where temp_table.product_id = ?",
            nativeQuery = true)
    List<ProductEAVVarchar> getByProductId(Long id);
}
