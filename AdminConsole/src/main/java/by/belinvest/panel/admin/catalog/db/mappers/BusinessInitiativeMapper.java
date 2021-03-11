package by.belinvest.panel.admin.catalog.db.mappers;

import by.belinvest.panel.admin.entity.catalog.BusinessInitiative;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BusinessInitiativeMapper implements RowMapper<BusinessInitiative> {

    public BusinessInitiative mapRow(ResultSet resultSet, int i) throws SQLException {
        BusinessInitiative businessInitiative = new BusinessInitiative();
        businessInitiative.setIdBi(resultSet.getString("IDBI"));
        businessInitiative.setProductDeveloperDept(resultSet.getString("PRODUCTDEVELOPERDEPT"));
        businessInitiative.setProductDeveloperFio(resultSet.getString("PRODUCTDEVELOPERFIO"));
        businessInitiative.setBiDate(resultSet.getString("BIDATE"));
        businessInitiative.setBiStatus(resultSet.getString("BISTATUS"));
        businessInitiative.setBiName(resultSet.getString("BINAME"));
        businessInitiative.setBiPoint(resultSet.getString("BIPOINT"));
        businessInitiative.setProduct(resultSet.getString("PRODUCT"));
        businessInitiative.setRealizeProspective(resultSet.getString("REALIZEPROSPECTIVE"));
        businessInitiative.setNonRealizeEffects(resultSet.getString("NONREALIZEEFFECTS"));
        businessInitiative.setImplPlanningDate(resultSet.getString("IMPLPLANNINGDATE"));
        businessInitiative.setAddInfo(resultSet.getString("ADDINFO"));
        businessInitiative.setMarketAnalisys(resultSet.getString("MARKETANALISYS"));
        businessInitiative.setMarketAnalisysFile(resultSet.getString("MARKETANALISYSFILE"));
        businessInitiative.setBusinessAppimplDate(resultSet.getString("BUSINESSAPPIMPLDATE"));
        businessInitiative.setPlanGraphicDate(resultSet.getString("PLANGRAPHICDATE"));

        return businessInitiative;
    }
}