package by.belinvest.panel.admin.catalog.db.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ReestrMapper implements RowMapper<ReestrDB> {

    public ReestrDB mapRow(ResultSet resultSet, int i) throws SQLException {
        ReestrDB reestr = new ReestrDB();
        reestr.setNoteId(resultSet.getString("ID"));
        reestr.setSign(resultSet.getString("SIGN"));
        reestr.setBusInitId(resultSet.getString("BUSINESSINITIATIVE_ID"));
        reestr.setBusInitName(resultSet.getString("BUSINESSINITIATIVE_NAME"));
        reestr.setBusInitStatus(resultSet.getString("BUSINESSINITIATIVE_STATUS"));
        reestr.setBusInitDate(resultSet.getString("BUSINESSINITIATIVE_DATE"));
        reestr.setBusOffId(resultSet.getString("BUSINESSOFFER_ID"));
        reestr.setBusOffName(resultSet.getString("BUSINESSOFFER_NAME"));
        reestr.setBusOffStatus(resultSet.getString("BUSINESSOFFER_STATUS"));
        reestr.setBusOffDate(resultSet.getString("BUSINESSOFFER_DATE"));
        reestr.setBusProdCardId(resultSet.getString("BPCARD_ID"));
        reestr.setBusProdCardProductName(resultSet.getString("BPCARD_PRODUCTNAME"));
        reestr.setBusProdCardProductStatus(resultSet.getString("BPCARD_PRODUCTSTATUS"));
       reestr.setProductHierId(resultSet.getString("PRODUCT_HIER_ID"));
        return reestr;
    }

}