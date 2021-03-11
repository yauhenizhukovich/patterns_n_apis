package by.belinvest.panel.admin.catalog.db.mappers;

import by.belinvest.panel.admin.entity.nsi.Directory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReestrDB extends Directory {

    private String noteId;
    private String sign;
    private String busInitId;
    private String busInitName;
    private String busInitStatus;
    private String busInitDate;
    private String busOffId;
    private String busOffName;
    private String busOffStatus;
    private String busOffDate;
    private String busProdCardId;
    private String busProdCardProductName;
    private String busProdCardProductStatus;
    private String productHierId;

}
