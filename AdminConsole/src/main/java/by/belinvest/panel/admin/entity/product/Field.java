package by.belinvest.panel.admin.entity.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Field {
    private Long id;
    private String name;
    private String value;
    private String tableName;
    private String fieldName;
    private String dataType;
    private Integer dataLength;
}
