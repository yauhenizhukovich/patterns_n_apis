package by.belinvest.panel.admin.product.dto;

import by.belinvest.panel.admin.entity.product.Field;
import by.belinvest.panel.admin.entity.product.ProductHierValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LevelUpdateData {
    private ArrayList<Field> fields;
    private String tableName;
    private ArrayList<String> productsId;
    private String hierarchyId;
    private String productGroupId;
    private String fieldNameProductCode;
    private List<ProductHierValue> productHierValues;
}
