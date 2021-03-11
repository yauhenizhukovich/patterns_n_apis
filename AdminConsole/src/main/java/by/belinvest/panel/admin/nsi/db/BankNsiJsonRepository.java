package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.bank_nsi_json.BankNsiJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class BankNsiJsonRepository {
    private static final String NAME_OF_TABLE = "'BANK_NSI_JSON'";

    private static final String GET_INFO_FROM_BANK_NSI_JSON_DIRECTORY_SQL = "SELECT * FROM BANK_NSI_JSON";
    private static final String INSERT_INFO_INTO_BANK_NSI_JSON_DIRECTORY_SQL = "INSERT INTO BANK_NSI_JSON (JSON_TABLE,NOTE,NAME,DATE_LOAD,URL_SRV,XML_TABLE,SQL_TEXT) VALUES (?,?,?,?,?,?,?,?)";
    private static final String UPDATE_INFO_INTO_BANK_NSI_JSON_DIRECTORY_SQL = "UPDATE BANK_NSI_JSON SET JSON_TABLE = ?,NOTE = ?,NAME = ?,DATE_LOAD = ?,URL_SRV = ?,XML_TABLE = ?,SQL_TEXT = ? WHERE ID = ?";
    private static final String DELETE_INFO_FROM_BANK_NSI_JSON_DIRECTORY_SQL = "DELETE FROM BANK_NSI_JSON WHERE ID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BankNsiJsonRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_BANK_NSI_JSON_DIRECTORY_SQL, new BeanPropertyRowMapper<>(BankNsiJson.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(BankNsiJson bankNsiJson) {
        jdbcTemplate.update(UPDATE_INFO_INTO_BANK_NSI_JSON_DIRECTORY_SQL,
                bankNsiJson.getJsonTable(),
                bankNsiJson.getNote(),
                bankNsiJson.getName(),
                bankNsiJson.getDateLoad(),
                bankNsiJson.getUrlSrv(),
                bankNsiJson.getXmlTable(),
                bankNsiJson.getSqlText(),
                bankNsiJson.getId());
        return true;
    }

    public boolean remove(String id) {
        jdbcTemplate.update(DELETE_INFO_FROM_BANK_NSI_JSON_DIRECTORY_SQL, id);
        return true;
    }

    public boolean create(BankNsiJson bankNsiJson) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_BANK_NSI_JSON_DIRECTORY_SQL,
                bankNsiJson.getJsonTable(),
                bankNsiJson.getNote(),
                bankNsiJson.getName(),
                bankNsiJson.getDateLoad(),
                bankNsiJson.getUrlSrv(),
                bankNsiJson.getXmlTable(),
                bankNsiJson.getSqlText()
        );
        return true;
    }
}
