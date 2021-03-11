package by.belinvest.panel.admin.entity.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCT_HIER_CRIT")
public class ProductHierCrit {
    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "SQ_PRODUCT_HIER_CRIT",
            sequenceName = "SQ_PRODUCT_HIER_CRIT", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "SQ_PRODUCT_HIER_CRIT")
    private Long id;

    @Column(name = "CRITERY_NAME")
    private String name;

    @Column(name = "TABLE_NAME")
    private String tableName;

    @Column(name = "FIELD_NAME")
    private String fieldName;

    @Column(name = "FIELD_TEXT")
    private String fieldText;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private ProductGroup productGroup;
}
