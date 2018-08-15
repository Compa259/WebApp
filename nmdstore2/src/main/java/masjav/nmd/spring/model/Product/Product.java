package masjav.nmd.spring.model.Product;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sku;

    private String type_id;

    private Boolean is_active;

    private Date created_at;

    private Date updated_at;

    @OneToMany(mappedBy = "product")
    private Set<ProductEAVVarchar> productEAVVarchars;

    @OneToMany(mappedBy = "product")
    private Set<ProductEAVLong> productEAVLongs;

    @OneToMany(mappedBy = "product")
    private Set<ProductEAVDateTime> productEAVDateTimes;

    @OneToMany(mappedBy = "product")
    private Set<ProductLink> productLinks;

//    @OneToMany(mappedBy = "product")
//    private Set<OrderProduct> orderProducts;

}
