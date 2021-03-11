package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.client_business_category.ClientBusinessCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class ClientBusinessCategoryRepository {
    private static final String NAME_OF_TABLE = "'CLIENT_BUSINESS_CATEGORY'";

    private static final String GET_INFO_FROM_CLIENT_BUSINESS_CATEGORY_DIRECTORY_SQL = "SELECT * FROM CLIENT_BUSINESS_CATEGORY";
    private static final String INSERT_INFO_INTO_CLIENT_BUSINESS_CATEGORY_DIRECTORY_SQL = "INSERT INTO CLIENT_BUSINESS_CATEGORY (PARENTID,CODE,NAME,CLB_EMPL_MIN_CNT,CLB_MAX_SUM,CLB_CREDIT_SUM_MIN,CLB_DEFAULT,CLB_PUBLIC_ADMIN,CLB_CREDIT_SUM_MAX,CLB_OWNERSHIP_TYPE,CLB_BG_SUM_MAX,CLB_EMPL_MAX_CNT,CLB_CONTRAGENT,CLB_BANK_CHILD_COMP,CLB_BG_SUM_MIN,CLB_MIN_SUM,CLB_CREDIT_DEBT_CUR,CLB_CURRENCY) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE_INFO_INTO_CLIENT_BUSINESS_CATEGORY_DIRECTORY_SQL = "UPDATE CLIENT_BUSINESS_CATEGORY SET PARENTID = ?,CODE = ?,NAME = ?,CLB_EMPL_MIN_CNT = ?,CLB_MAX_SUM = ?,CLB_CREDIT_SUM_MIN = ?,CLB_DEFAULT = ?,CLB_PUBLIC_ADMIN = ?,CLB_CREDIT_SUM_MAX = ?,CLB_OWNERSHIP_TYPE = ?,CLB_BG_SUM_MAX = ?,CLB_EMPL_MAX_CNT = ?,CLB_CONTRAGENT = ?,CLB_BANK_CHILD_COMP = ?,CLB_BG_SUM_MIN = ?,CLB_MIN_SUM = ?,CLB_CREDIT_DEBT_CUR = ?,CLB_CURRENCY = ? WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_CLIENT_BUSINESS_CATEGORY_DIRECTORY_SQL = "DELETE FROM CLIENT_BUSINESS_CATEGORY WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientBusinessCategoryRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_CLIENT_BUSINESS_CATEGORY_DIRECTORY_SQL, new BeanPropertyRowMapper<>(ClientBusinessCategory.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(ClientBusinessCategory clientBusinessCategory) {
        jdbcTemplate.update(UPDATE_INFO_INTO_CLIENT_BUSINESS_CATEGORY_DIRECTORY_SQL,
                clientBusinessCategory.getParentId(),
                clientBusinessCategory.getCode(),
                clientBusinessCategory.getName(),
                clientBusinessCategory.getClbEmplMinCnt(),
                clientBusinessCategory.getClbMaxSum(),
                clientBusinessCategory.getClbCreditSumMin(),
                clientBusinessCategory.getClbDefault(),
                clientBusinessCategory.getClbPublicAdmin(),
                clientBusinessCategory.getClbCreditSumMax(),
                clientBusinessCategory.getClbOwnershipType(),
                clientBusinessCategory.getClbBgSumMax(),
                clientBusinessCategory.getClbEmplMaxCnt(),
                clientBusinessCategory.getClbContragent(),
                clientBusinessCategory.getClbBankChildComp(),
                clientBusinessCategory.getClbBgSumMin(),
                clientBusinessCategory.getClbMinSum(),
                clientBusinessCategory.getClbCreditDebtCur(),
                clientBusinessCategory.getClbCurrency(),
                clientBusinessCategory.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_CLIENT_BUSINESS_CATEGORY_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(ClientBusinessCategory clientBusinessCategory) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_CLIENT_BUSINESS_CATEGORY_DIRECTORY_SQL,
                clientBusinessCategory.getParentId(),
                clientBusinessCategory.getCode(),
                clientBusinessCategory.getName(),
                clientBusinessCategory.getClbEmplMinCnt(),
                clientBusinessCategory.getClbMaxSum(),
                clientBusinessCategory.getClbCreditSumMin(),
                clientBusinessCategory.getClbDefault(),
                clientBusinessCategory.getClbPublicAdmin(),
                clientBusinessCategory.getClbCreditSumMax(),
                clientBusinessCategory.getClbOwnershipType(),
                clientBusinessCategory.getClbBgSumMax(),
                clientBusinessCategory.getClbEmplMaxCnt(),
                clientBusinessCategory.getClbContragent(),
                clientBusinessCategory.getClbBankChildComp(),
                clientBusinessCategory.getClbBgSumMin(),
                clientBusinessCategory.getClbMinSum(),
                clientBusinessCategory.getClbCreditDebtCur(),
                clientBusinessCategory.getClbCurrency());
        return true;
    }
}