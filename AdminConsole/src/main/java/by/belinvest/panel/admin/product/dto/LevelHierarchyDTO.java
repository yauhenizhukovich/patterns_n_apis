package by.belinvest.panel.admin.product.dto;

import by.belinvest.panel.admin.entity.product.Field;
import by.belinvest.panel.admin.entity.product.ProductHierCrit;
import by.belinvest.panel.admin.entity.product.ValueNSI;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LevelHierarchyDTO {
    List<ValueNSI> lineValues;
    List<ProductHierCrit> criterionList;
    List<Field> fieldList;
}