package by.belinvest.panel.admin.entity.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TreeElement {
    private List<TreeElement> child;

    private String id;
    private String hiId;
    private Byte lev;
    private String name;
    private Byte typ;
    private Long realHiId;
    private Long realId;
    private Long prodHierId;

    private ProductElement productElement;

    @Override
    public String toString() {
        return "TreeElement{" +
                "lev=" + lev +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", hiId='" + hiId + '\'' +
                ", realId='" + realId + '\'' +
                ", realHiId='" + realHiId + '\'' +
                ", prodHierId='" + prodHierId + '\'' +
                "child=" + child +
                '}';
    }
}
