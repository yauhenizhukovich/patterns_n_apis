package by.belinvest.panel.admin.nsi.db;

import javax.sql.DataSource;

import by.belinvest.panel.admin.entity.nsi.dep_product_line.DepProductLine;
import by.belinvest.panel.admin.entity.nsi.depfl_product_line.DepflProductLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ListRepository {

    private JdbcTemplate jdbcTemplateCatalog;

    @Autowired
    public ListRepository(@Qualifier("catalogDatasource") DataSource dataSourceCatalog) {
        this.jdbcTemplateCatalog = new JdbcTemplate(dataSourceCatalog);
    }

    public void create(DepProductLine depProductLine, String bpcId) {
        Long productHierId;
        // получение ID иерархии продуктов по наименованию линейки и имени таблицы
        List<Long> list = jdbcTemplateCatalog.queryForList(
                "select PRODUCT_HIER_ID from (select distinct hc.TABLE_NAME, hs.PRODUCT_HIER_ID, hv.VALUE from product_hier_crit hc, product_hier_struct hs, product_hier_value hv where hc.ID = hs.crit and hv.IDSTRUCT = hs.ID and lev = 1) where TABLE_NAME = 'NSI.DEP_PRODUCT_LINE' and VALUE = '" + depProductLine
                        .getName() + "'",
                Long.class);
        if (!list.isEmpty()){
            productHierId = list.get(0);
            jdbcTemplateCatalog.execute("update LIST_BI set PRODUCT_HIER_ID = " + productHierId + " WHERE BPCARD_ID = " + bpcId);
        }

    }

    public void create(DepflProductLine depflProductLine, String bpcId) {
        // получение ID иерархии продуктов по наименованию линейки и имени таблицы
        Long productHierId;
        List<Long> list = jdbcTemplateCatalog.queryForList(
                "select PRODUCT_HIER_ID from (select distinct hc.TABLE_NAME, hs.PRODUCT_HIER_ID, hv.VALUE from product_hier_crit hc, product_hier_struct hs, product_hier_value hv where hc.ID = hs.crit and hv.IDSTRUCT = hs.ID and lev = 1) where TABLE_NAME = 'NSI.DEP_PRODUCT_LINE' and VALUE = '" + depflProductLine
                        .getName() + "'",
                Long.class);
        if (!list.isEmpty()) {
            // обновление записи в реестре БИ - установка идентификатора иерархии продуктов
            productHierId = list.get(0);
            jdbcTemplateCatalog.execute("update LIST_BI set PRODUCT_HIER_ID = " + productHierId + " WHERE BPCARD_ID = " + bpcId);
        }
    }

}
