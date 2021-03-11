package by.belinvest.panel.admin.product.dto;


import by.belinvest.panel.admin.entity.product.ProductGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProductGroupDTO {
    private Long id;
    private String name;
    private Long hiId;
    private String tableName;
    private String productName;
    private String productCode;

    public static ProductGroupDTO toDTO(ProductGroup productGroup){
        return ProductGroupDTO.builder()
                .id(productGroup.getId())
                .hiId(productGroup.getHiId())
                .name(productGroup.getName())
                .tableName(productGroup.getTableName())
                .productCode(productGroup.getProductCode())
                .productName(productGroup.getProductName())
                .build();
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                " ,\"name\":\"" + name + '\"' +
                " ,\"hiId\":" + hiId +
                " ,\"tableName\":\"" + tableName + '\"' +
                " ,\"productName\":\"" + productName + '\"' +
                " ,\"productCode\":\"" + productCode + '\"' +
                '}';
    }
}
