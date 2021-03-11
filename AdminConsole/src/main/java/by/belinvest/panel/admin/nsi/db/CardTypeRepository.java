package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.cardtype.CardType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class CardTypeRepository {

    private static final String NAME_OF_TABLE = "'CARDTYPE'";

    private static final String GET_INFO_FROM_CARDTYPE_DIRECTORY_SQL = "SELECT * FROM CARDTYPE";
    private static final String INSERT_INFO_INTO_CARDTYPE_DIRECTORY_SQL = "INSERT INTO CARDTYPE (NAME,CODE,CUR_LIST,CARDTYPE_CATEGORY,CARDTYPE_PS,CARDTYPE_TECHNOLOGY,CARDTYPE_TYPE_ADD_SERVICE,COLOR_IB) VALUES (?,?,?,?,?,?,?,?)";
    private static final String UPDATE_INFO_INTO_CARDTYPE_DIRECTORY_SQL = "UPDATE CARDTYPE SET NAME = ?,CODE = ?,CUR_LIST = ?,CARDTYPE_CATEGORY = ?,CARDTYPE_PS = ?,CARDTYPE_TECHNOLOGY = ?,CARDTYPE_TYPE_ADD_SERVICE = ?,COLOR_IB = ? WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_CARDTYPE_DIRECTORY_SQL = "DELETE FROM CARDTYPE WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CardTypeRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_CARDTYPE_DIRECTORY_SQL, new BeanPropertyRowMapper<>(CardType.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(CardType cardType) {
        jdbcTemplate.update(UPDATE_INFO_INTO_CARDTYPE_DIRECTORY_SQL,
                cardType.getName(),
                cardType.getCode(),
                cardType.getCurList(),
                cardType.getCardtypeCategory(),
                cardType.getCardtypePs(),
                cardType.getCardtypeTechnology(),
                cardType.getCardtypeTypeAddService(),
                cardType.getColorIb(),
                cardType.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_CARDTYPE_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(CardType cardType) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_CARDTYPE_DIRECTORY_SQL,
                cardType.getName(),
                cardType.getCode(),
                cardType.getCurList(),
                cardType.getCardtypeCategory(),
                cardType.getCardtypePs(),
                cardType.getCardtypeTechnology(),
                cardType.getCardtypeTypeAddService(),
                cardType.getColorIb()
        );
        return true;
    }
}
