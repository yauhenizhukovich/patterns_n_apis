package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.nsi_805.Nsi805;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class Nsi805Repository {

    private static final String NAME_OF_TABLE = "'NSI_805'";

    private static final String GET_INFO_FROM_NSI_805_DIRECTORY_SQL = "SELECT * FROM NSI_805";
    private static final String INSERT_INFO_INTO_NSI_805_DIRECTORY_SQL = "INSERT INTO NSI_805 (PARENTID,CODE,NAME,KR_VID_SDELKI_805,KR_OBESP_805) VALUES (?,?,?,?)";
    private static final String UPDATE_INFO_INTO_NSI_805_DIRECTORY_SQL = "UPDATE NSI_805 SET PARENTID = ?,CODE = ?,NAME = ?,KR_VID_SDELKI_805 = ?,KR_OBESP_805 = ? WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_NSI_805_DIRECTORY_SQL = "DELETE FROM NSI_805 WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public Nsi805Repository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_NSI_805_DIRECTORY_SQL, new BeanPropertyRowMapper<>(Nsi805.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(Nsi805 nsi805) {
        jdbcTemplate.update(UPDATE_INFO_INTO_NSI_805_DIRECTORY_SQL,
                nsi805.getParentId(),
                nsi805.getCode(),
                nsi805.getName(),
                nsi805.getKrVidSdelki805(),
                nsi805.getKrObesp805(),
                nsi805.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_NSI_805_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(Nsi805 nsi805) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_NSI_805_DIRECTORY_SQL,
                nsi805.getParentId(),
                nsi805.getCode(),
                nsi805.getName(),
                nsi805.getKrVidSdelki805(),
                nsi805.getKrObesp805()
        );
        return true;
    }
}
