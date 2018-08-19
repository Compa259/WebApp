package masjav.nmd.spring.repository;

import masjav.nmd.spring.model.Product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    Product save(Product product);

    Product findById(Long id);

    Page<Product> findAllByCategoryId(Long id, Pageable pageable);

    @Query(value = "select * from product where created_at >= date_sub(curdate(), INTERVAL 30 DAY) and created_at <= curdate() /*#pageable*/",
            countQuery = "select count(*) from product where created_at >= date_sub(curdate(), INTERVAL 30 DAY) and created_at <= curdate()",
            nativeQuery = true)
    Page<Product> findByNew(Pageable pageable);

    @Query(value = "select * from product where id in (select product_id from product_eav_varchar where product_attribute_id = 4) /*#pageable*/",
            countQuery = "select count(*) from product where id in (select product_id from product_eav_varchar where product_attribute_id = 4)",
            nativeQuery = true)
    Page<Product> findBySale(Pageable pageable);

    @Query(value = "select * \n" +
                    "from product \n" +
                    "inner join\n" +
                    "(  \n" +
                    "\tselect product_id, sum(quantity) as sum_num \n" +
                    "\tfrom order_product \n" +
                    "\tgroup by product_id order by sum_num DESC\n" +
                    ") as temp_table\n" +
                    "on product.id = temp_table.product_id\n" +
                    "order by sum_num DESC /*#pageable*/",
            countQuery = "select * \n" +
                        "from product \n" +
                        "inner join\n" +
                        "(  \n" +
                        "\tselect product_id, sum(quantity) as sum_num \n" +
                        "\tfrom order_product \n" +
                        "\tgroup by product_id order by sum_num DESC\n" +
                        ") as temp_table\n" +
                        "on product.id = temp_table.product_id\n" +
                        "order by sum_num DESC",
            nativeQuery = true)
    Page<Product> findByTop(Pageable pageable);

    @Query(value = "select * \n" +
                    "from product \n" +
                    "inner join\n" +
                    "(  \n" +
                    "\tselect product_id, sum(quantity) as sum_num \n" +
                    "\tfrom order_product \n" +
                    "\tgroup by product_id order by sum_num DESC\n" +
                    ") as temp_table\n" +
                    "on product.id = temp_table.product_id\n" +
                    "where category_id = ?\n" +
                    "order by sum_num DESC /*#pageable*/",
            countQuery = "select * \n" +
                    "from product \n" +
                    "inner join\n" +
                    "(  \n" +
                    "\tselect product_id, sum(quantity) as sum_num \n" +
                    "\tfrom order_product \n" +
                    "\tgroup by product_id order by sum_num DESC\n" +
                    ") as temp_table\n" +
                    "on product.id = temp_table.product_id\n" +
                    "where category_id = ?\n" +
                    "order by sum_num DESC",
            nativeQuery = true)
    Page<Product> findByTopFollowCategory(Long id, Pageable pageable);

//    Product getProductDetail(Long id);
}
