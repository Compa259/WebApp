package masjav.nmd.spring.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table (name = "News")
public class News {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

}
