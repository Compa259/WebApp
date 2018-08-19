package masjav.nmd.spring.model.Category;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import masjav.nmd.spring.model.Product.Product;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long parent_id;

    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private Set<Product> products;

    public String toString(){
        return "nmdstore2";
    }
}
