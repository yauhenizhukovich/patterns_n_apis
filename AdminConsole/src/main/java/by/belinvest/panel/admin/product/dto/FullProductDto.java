package by.belinvest.panel.admin.product.dto;

import by.belinvest.panel.admin.entity.product.Field;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FullProductDto {
    private ProductDTO productDTO;
    private List<Field> fields;
}
