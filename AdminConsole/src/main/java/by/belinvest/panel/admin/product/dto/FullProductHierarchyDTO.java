package by.belinvest.panel.admin.product.dto;

import by.belinvest.panel.admin.entity.product.Field;
import by.belinvest.panel.admin.entity.product.Level;
import by.belinvest.panel.admin.entity.product.ProductHierarchy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class FullProductHierarchyDTO {

    private ProductGroupDTO firstProductGroup;
    private ProductGroupDTO secondProductGroup;
    private String author;
    private List<Level> levels;
    private ProductHierarchyDTO productHierarchyDTO;
    private List<Field> freeFields;
    private List<ProductDTO> productList;
    private String productLine;
    private boolean haveProducts;
    
    public static List<FullProductHierarchyDTO> toDTOList(List<ProductHierarchy> productHierarchyList){
        List<FullProductHierarchyDTO> productHierarchyDTOList = new ArrayList<>();
        FullProductHierarchyDTO productHierarchyDTO;

        for (ProductHierarchy productHierarchy: productHierarchyList) {
            productHierarchyDTO = new FullProductHierarchyDTO();
            productHierarchyDTO.setProductHierarchyDTO(ProductHierarchyDTO.toDTO(productHierarchy));
            productHierarchyDTOList.add(productHierarchyDTO);
        }

        return productHierarchyDTOList;
    }

    public static FullProductHierarchyDTO toDTO(ProductHierarchy productHierarchy){
        FullProductHierarchyDTO fullProductHierarchyDTO = new FullProductHierarchyDTO();
        fullProductHierarchyDTO.setProductHierarchyDTO(ProductHierarchyDTO.toDTO(productHierarchy));
        return fullProductHierarchyDTO;
    }

    public FullProductHierarchyDTO() {
        this.levels = new ArrayList<>();
    }
}
