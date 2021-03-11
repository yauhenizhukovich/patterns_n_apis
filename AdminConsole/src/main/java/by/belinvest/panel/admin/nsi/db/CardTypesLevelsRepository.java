package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.card_types_levels.CardTypesLevels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class CardTypesLevelsRepository {
    private static final String NAME_OF_TABLE = "'CARD_TYPES_LEVELS'";

    private static final String GET_INFO_FROM_CARD_TYPES_LEVELS_DIRECTORY_SQL = "SELECT * FROM CARD_TYPES_LEVELS";
    private static final String INSERT_INFO_INTO_CARD_TYPES_LEVELS_DIRECTORY_SQL = "INSERT INTO CARD_TYPES_LEVELS (NAME,CODE,CTL_ORDER) VALUES (?,?,?)";
    private static final String UPDATE_INFO_INTO_CARD_TYPES_LEVELS_DIRECTORY_SQL = "UPDATE CARD_TYPES_LEVELS SET NAME = ?,CODE = ?,CTL_ORDER = ? WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_CARD_TYPES_LEVELS_DIRECTORY_SQL = "DELETE FROM CARD_TYPES_LEVELS WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CardTypesLevelsRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_CARD_TYPES_LEVELS_DIRECTORY_SQL, new BeanPropertyRowMapper<>(CardTypesLevels.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(CardTypesLevels cardTypesLevels) {
        jdbcTemplate.update(UPDATE_INFO_INTO_CARD_TYPES_LEVELS_DIRECTORY_SQL,
                cardTypesLevels.getName(),
                cardTypesLevels.getCode(),
                cardTypesLevels.getCtlOrder(),
                cardTypesLevels.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_CARD_TYPES_LEVELS_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(CardTypesLevels cardTypesLevels) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_CARD_TYPES_LEVELS_DIRECTORY_SQL,
                cardTypesLevels.getName(),
                cardTypesLevels.getCode(),
                cardTypesLevels.getCtlOrder()
        );
        return true;
    }
}
