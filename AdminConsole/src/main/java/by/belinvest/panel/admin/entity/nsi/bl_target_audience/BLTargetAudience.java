package by.belinvest.panel.admin.entity.nsi.bl_target_audience;

import by.belinvest.panel.admin.entity.nsi.Directory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BLTargetAudience extends Directory {
    private String code;
    private String name;

    public static BLTargetAudience fromJSON(HashMap<String,String> json){
        return BLTargetAudience.builder()
                .name(json.get("NAME"))
                .code(json.get("id"))
                .build();
    }
}
