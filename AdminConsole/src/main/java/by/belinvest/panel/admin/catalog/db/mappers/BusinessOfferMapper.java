package by.belinvest.panel.admin.catalog.db.mappers;

import by.belinvest.panel.admin.entity.catalog.BusinessOffer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BusinessOfferMapper implements RowMapper<BusinessOffer> {

    public BusinessOffer mapRow(ResultSet resultSet, int i) throws SQLException {
        BusinessOffer businessOffer = new BusinessOffer();
        businessOffer.setIdBo(resultSet.getString("IDBO"));
        businessOffer.setBoName(resultSet.getString("BONAME"));
        businessOffer.setBoStatus(resultSet.getString("BOSTATUS"));
        businessOffer.setProductManeger(resultSet.getString("PRODUCTMANAGER"));
        businessOffer.setProductManegerPosition(resultSet.getString("PRODUCTMANAGERPOSITION"));
        businessOffer.setProductManegerPhone(resultSet.getString("PRODUCTMANAGERPHONE"));
        businessOffer.setProductManegerDept(resultSet.getString("PRODUCTMANAGERDEPT"));
        businessOffer.setProductManegerSupervisor(resultSet.getString("PRODUCTMANAGERSUPERVISOR"));
        businessOffer.setProductManegerSupervisorPos(resultSet.getString("PRODUCTMANAGERSUPERVISORPOS"));
        businessOffer.setProductManegerSupervisorPhone(resultSet.getString("PRODUCTMANAGERSUPERVISORPHONE"));


        return businessOffer;
    }
}