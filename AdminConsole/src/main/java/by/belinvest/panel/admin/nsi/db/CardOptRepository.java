package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.cardopt.CardOpt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class CardOptRepository {
    private static final String NAME_OF_TABLE = "'CARDOPT'";

    private static final String GET_INFO_FROM_CARDOPT_DIRECTORY_SQL = "SELECT * FROM CARDOPT";
    private static final String INSERT_INFO_INTO_CARDOPT_DIRECTORY_SQL = "INSERT INTO CARDOPT (NAME,CODE,CARD_OPT_ELEMENT,CARD_OPT_SEARCH) VALUES (?,?,?,?)";
    private static final String UPDATE_INFO_INTO_CARDOPT_DIRECTORY_SQL = "UPDATE CARDOPT SET NAME = ?,CODE = ?,CARD_OPT_ELEMENT = ?,CARD_OPT_SEARCH = ? WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_CARDOPT_DIRECTORY_SQL = "DELETE FROM CARDOPT WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CardOptRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_CARDOPT_DIRECTORY_SQL, new BeanPropertyRowMapper<>(CardOpt.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(CardOpt cardOpt) {
        jdbcTemplate.update(UPDATE_INFO_INTO_CARDOPT_DIRECTORY_SQL,
                cardOpt.getName(),
                cardOpt.getCode(),
                cardOpt.getCardOptElement(),
                cardOpt.getCardOptSearch(),
                cardOpt.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_CARDOPT_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(CardOpt cardOpt) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_CARDOPT_DIRECTORY_SQL,
                cardOpt.getName(),
                cardOpt.getCode(),
                cardOpt.getCardOptElement(),
                cardOpt.getCardOptSearch()
        );
        return true;
    }
}
