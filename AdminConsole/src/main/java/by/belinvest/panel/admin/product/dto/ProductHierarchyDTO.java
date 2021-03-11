package by.belinvest.panel.admin.product.dto;

import by.belinvest.panel.admin.entity.product.ProductHierarchy;
import by.belinvest.panel.admin.entity.product.ProductHierarchyStruct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductHierarchyDTO {

    private Long id;
    private String name;
    private Integer activity;
    private Integer levelQuant;
    private LocalDate dateBegin;
    private LocalDate dateEnd;
    private Integer userId;
    private Long lineId;
    private ProductGroupDTO productGroupDTO;
    private List<ProductHierarchyStruct> productHierarchyStructs;


    public static ProductHierarchyDTO toDTO(ProductHierarchy productHierarchy){
        return ProductHierarchyDTO.builder()
                .id(productHierarchy.getId())
                .name(productHierarchy.getName())
                .activity(productHierarchy.getActivity())
                .levelQuant(productHierarchy.getLevelQuant())
                .dateBegin(productHierarchy.getDateBegin())
                .dateEnd(productHierarchy.getDateEnd())
                .userId(productHierarchy.getUserId())
                .lineId(productHierarchy.getLineId())
                .productGroupDTO(ProductGroupDTO.toDTO(productHierarchy.getProductGroup()))
                .productHierarchyStructs(productHierarchy.getProductHierarchyStructs())
                .build();
    }

}
