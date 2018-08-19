package masjav.nmd.spring.model.Product;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import masjav.nmd.spring.model.Category.Category;
import masjav.nmd.spring.model.OrderProduct.OrderProductId;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
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
    @JsonBackReference
//    @JsonManagedReference
    private Set<ProductEAVVarchar> productEAVVarchars;

    @OneToMany(mappedBy = "product")
    @JsonBackReference
    private Set<ProductEAVLong> productEAVLongs;

    @OneToMany(mappedBy = "product")
    private Set<ProductEAVDateTime> productEAVDateTimes;

    @OneToMany(mappedBy = "product")
    private Set<ProductLink> productLinks;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public String toString(){
        return "nmdstore2";
    }
//    @OneToMany(mappedBy = "product")
//    private Set<OrderProduct> orderProducts;

    @OneToMany(mappedBy = "product")
    private Set<ProductInstance> productInstances;
}
