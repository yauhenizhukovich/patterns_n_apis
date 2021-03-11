package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.nsi_116.Nsi116;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class Nsi116Repository {
    private static final String NAME_OF_TABLE = "'NSI_116'";

    private static final String GET_INFO_FROM_NSI_116_DIRECTORY_SQL = "SELECT * FROM NSI_116";
    private static final String INSERT_INFO_INTO_NSI_116_DIRECTORY_SQL = "INSERT INTO NSI_116 (PARENTID,CODE,NAME,NSI_116_SH_VD,NSI_116_GROUP_NUM,NSI_116_TARIF,NSI_116_OP,NSI_116_DATE_CLOSE,NSI_116_TUNN,NSI_116_AVALIABLE_FOR_DBO,NSI_116_TMIN,NSI_116_NOPAY,NSI_116_SH_VO,NSI_116_TYPE_TARIF,NSI_116_DATE_OPEN,NSI_116_SH_OP,NSI_116_PACK_GROUP,NSI_116_VAL,NSI_116_SH_NP,NSI_116_TMAX,NSI_116_TPODR,NSI_116_TYPE_ITEM,NSI_116_TVAL) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE_INFO_INTO_NSI_116_DIRECTORY_SQL = "UPDATE NSI_116 SET PARENTID = ?,CODE = ?,NAME = ?,NSI_116_SH_VD = ?,NSI_116_GROUP_NUM = ?,NSI_116_TARIF = ?,NSI_116_OP = ?,NSI_116_DATE_CLOSE = ?,NSI_116_TUNN = ?,NSI_116_AVALIABLE_FOR_DBO = ?,NSI_116_TMIN = ?,NSI_116_NOPAY = ?,NSI_116_SH_VO = ?,NSI_116_TYPE_TARIF = ?,NSI_116_DATE_OPEN = ?,NSI_116_SH_OP = ?,NSI_116_PACK_GROUP = ?,NSI_116_VAL = ?,NSI_116_SH_NP = ?,NSI_116_TMAX = ?,NSI_116_TPODR = ?,NSI_116_TYPE_ITEM = ?,NSI_116_TVAL = ?  WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_NSI_116_DIRECTORY_SQL = "DELETE FROM NSI_116 WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public Nsi116Repository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_NSI_116_DIRECTORY_SQL, new BeanPropertyRowMapper<>(Nsi116.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(Nsi116 nsi116) {
        jdbcTemplate.update(UPDATE_INFO_INTO_NSI_116_DIRECTORY_SQL,
                nsi116.getCode(),
                nsi116.getName(),
                nsi116.getNsi116ShVd(),
                nsi116.getNsi116GroupNum(),
                nsi116.getNsi116TypeTarif(),
                nsi116.getNsi116ShOp(),
                nsi116.getNsi116DateClose(),
                nsi116.getNsi116Tunn(),
                nsi116.getNsi116AvaliableForDbo(),
                nsi116.getNsi116Tmin(),
                nsi116.getNsi116Nopay(),
                nsi116.getNsi116ShVo(),
                nsi116.getNsi116TypeTarif(),
                nsi116.getNsi116DateOpen(),
                nsi116.getNsi116ShOp(),
                nsi116.getNsi116PackGroup(),
                nsi116.getNsi116Tval(),
                nsi116.getNsi116Val(),
                nsi116.getNsi116ShNp(),
                nsi116.getNsi116Tmax(),
                nsi116.getNsi116Tpodr(),
                nsi116.getNsi116TypeItem(),
                nsi116.getNsi116Tval(),
                nsi116.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_NSI_116_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(Nsi116 nsi116) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_NSI_116_DIRECTORY_SQL,
                nsi116.getCode(),
                nsi116.getName(),
                nsi116.getNsi116ShVd(),
                nsi116.getNsi116GroupNum(),
                nsi116.getNsi116TypeTarif(),
                nsi116.getNsi116ShOp(),
                nsi116.getNsi116DateClose(),
                nsi116.getNsi116Tunn(),
                nsi116.getNsi116AvaliableForDbo(),
                nsi116.getNsi116Tmin(),
                nsi116.getNsi116Nopay(),
                nsi116.getNsi116ShVo(),
                nsi116.getNsi116TypeTarif(),
                nsi116.getNsi116DateOpen(),
                nsi116.getNsi116ShOp(),
                nsi116.getNsi116PackGroup(),
                nsi116.getNsi116Tval(),
                nsi116.getNsi116Val(),
                nsi116.getNsi116ShNp(),
                nsi116.getNsi116Tmax(),
                nsi116.getNsi116Tpodr(),
                nsi116.getNsi116TypeItem(),
                nsi116.getNsi116Tval()
        );
        return true;
    }
}
