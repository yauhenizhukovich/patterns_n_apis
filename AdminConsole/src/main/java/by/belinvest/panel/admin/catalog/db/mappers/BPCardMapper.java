package by.belinvest.panel.admin.catalog.db.mappers;

import by.belinvest.panel.admin.entity.catalog.BPCard;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BPCardMapper implements RowMapper<BPCard> {

    public BPCard mapRow(ResultSet resultSet, int i) throws SQLException {
        BPCard bpCard = new BPCard();
        bpCard.setbPId(resultSet.getString("BPID"));
        bpCard.setProductName(resultSet.getString("PRODUCTNAME"));
        bpCard.setCommonProductChars(resultSet.getString("COMMONPRODUCTCHARS"));
        bpCard.setProductStatus(resultSet.getString("PRODUCTSTATUS"));
        bpCard.setChangeStatusDate(resultSet.getString("CHANGESTATUSDATE"));
        bpCard.setProductAdvantages(resultSet.getString("PRODUCTADVANTAGES"));
        bpCard.setMainProductParams(resultSet.getString("MAINPRODUCTPARAMS"));
        bpCard.setDocsForms(resultSet.getString("DOCSFORMS"));
        bpCard.setLbaBanks(resultSet.getString("LPABANKS"));
        bpCard.setAddMaterials(resultSet.getString("ADDMATERIALS"));


        return bpCard;
    }
}