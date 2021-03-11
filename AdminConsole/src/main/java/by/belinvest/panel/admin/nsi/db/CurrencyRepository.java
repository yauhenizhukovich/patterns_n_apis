package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.currency.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class CurrencyRepository {

    private static final String NAME_OF_TABLE = "'CURRENCY'";

    private static final String GET_INFO_FROM_CURRENCY_DIRECTORY_SQL = "SELECT * FROM CURRENCY";
    private static final String INSERT_INFO_INTO_CURRENCY_DIRECTORY_SQL = "INSERT INTO CURRENCY (PARENTID,CODE,NAME,KURS_KOL,STATE,BBB_CODE,FGENDER,CURR_PERIOD_KOT,CURR_ORDER,SIGN_KONTROL,PRINT_1P,PRINT_1R,PRINT_2R,PRINT_NP,IGENDER,PRINT_NR,PRINT_FNR,KURS_PRICE,KOD_CURR_NUM,PRINT_F2R,PRINT_F1,CURR_TYPE) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE_INFO_INTO_CURRENCY_DIRECTORY_SQL = "UPDATE CURRENCY SET PARENTID = ?,CODE = ?,NAME = ?,KURS_KOL = ?,STATE = ?,BBB_CODE = ?,FGENDER = ?,CURR_PERIOD_KOT = ?,CURR_ORDER = ?,SIGN_KONTROL = ?,PRINT_1P = ?,PRINT_1R = ?,PRINT_2R = ?,PRINT_NP = ?,IGENDER = ?,PRINT_NR = ?,PRINT_FNR = ?,KURS_PRICE = ?,KOD_CURR_NUM = ?,PRINT_F2R = ?,PRINT_F1 = ?,CURR_TYPE = ? WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_CURRENCY_DIRECTORY_SQL = "DELETE FROM CURRENCY WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CurrencyRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_CURRENCY_DIRECTORY_SQL, new BeanPropertyRowMapper<>(Currency.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(Currency currency) {
        jdbcTemplate.update(UPDATE_INFO_INTO_CURRENCY_DIRECTORY_SQL,
                currency.getParentId(),
                currency.getCode(),
                currency.getName(),
                currency.getKursKol(),
                currency.getState(),
                currency.getBbbCode(),
                currency.getFgender(),
                currency.getCurrPeriodKot(),
                currency.getCurrOrder(),
                currency.getSignKontrol(),
                currency.getPrint1P(),
                currency.getPrint1R(),
                currency.getPrint2R(),
                currency.getPrintNP(),
                currency.getIgender(),
                currency.getPrintNR(),
                currency.getPrintFNR(),
                currency.getKursPrice(),
                currency.getKodCurrNum(),
                currency.getPrintF2R(),
                currency.getPrintF1(),
                currency.getCurrType(),
                currency.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_CURRENCY_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(Currency currency) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_CURRENCY_DIRECTORY_SQL,
                currency.getParentId(),
                currency.getCode(),
                currency.getName(),
                currency.getKursKol(),
                currency.getState(),
                currency.getBbbCode(),
                currency.getFgender(),
                currency.getCurrPeriodKot(),
                currency.getCurrOrder(),
                currency.getSignKontrol(),
                currency.getPrint1P(),
                currency.getPrint1R(),
                currency.getPrint2R(),
                currency.getPrintNP(),
                currency.getIgender(),
                currency.getPrintNR(),
                currency.getPrintFNR(),
                currency.getKursPrice(),
                currency.getKodCurrNum(),
                currency.getPrintF2R(),
                currency.getPrintF1(),
                currency.getCurrType()
        );
        return true;
    }
}
