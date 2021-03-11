package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.ownership_okrb.OwnershipOkrb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class OwnershipOkrbRepository {
    private static final String NAME_OF_TABLE = "'OWNERSHIP_OKRB'";

    private static final String GET_INFO_FROM_OWNERSHIP_OKRB_DIRECTORY_SQL = "SELECT * FROM OWNERSHIP_OKRB";
    private static final String INSERT_INFO_INTO_OWNERSHIP_OKRB_DIRECTORY_SQL = "INSERT INTO OWNERSHIP_OKRB (PARENTID,CODE,NAME) VALUES (?,?,?)";
    private static final String UPDATE_INFO_INTO_OWNERSHIP_OKRB_DIRECTORY_SQL = "UPDATE OWNERSHIP_OKRB SET PARENTID = ?,CODE = ?,NAME = ? WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_OWNERSHIP_OKRB_DIRECTORY_SQL = "DELETE FROM OWNERSHIP_OKRB WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public OwnershipOkrbRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_OWNERSHIP_OKRB_DIRECTORY_SQL, new BeanPropertyRowMapper<>(OwnershipOkrb.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(OwnershipOkrb ownershipOkrb) {
        jdbcTemplate.update(UPDATE_INFO_INTO_OWNERSHIP_OKRB_DIRECTORY_SQL,
                ownershipOkrb.getParentId(),
                ownershipOkrb.getCode(),
                ownershipOkrb.getName(),
                ownershipOkrb.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_OWNERSHIP_OKRB_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(OwnershipOkrb ownershipOkrb) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_OWNERSHIP_OKRB_DIRECTORY_SQL,
                ownershipOkrb.getParentId(),
                ownershipOkrb.getCode(),
                ownershipOkrb.getName()
        );
        return true;
    }
}
