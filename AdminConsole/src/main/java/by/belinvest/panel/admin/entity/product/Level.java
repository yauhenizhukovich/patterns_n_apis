package by.belinvest.panel.admin.entity.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Level {
    private Long productHierStructId;
    private Integer level;
    private List<Criterion> criterionList;
    private List<Field> fieldList = new ArrayList<>();
}
