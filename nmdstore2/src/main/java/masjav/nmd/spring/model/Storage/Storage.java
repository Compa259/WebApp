package masjav.nmd.spring.model.Storage;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "storage")
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long remainning_num;

    private Long sold_num;

    private Long total_num;

    private Long product_value_id;

    private String product_value_type;
}
