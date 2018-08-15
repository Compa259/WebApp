package masjav.nmd.spring.model.Category;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "category")
public class Category {
    @Id
    private Long id;

    private String name;

    private Long parent_id;
}
