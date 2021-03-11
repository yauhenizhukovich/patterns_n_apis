package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.kd_pok_bris.KdPokBris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class KdPokBrisRepository {

    private static final String NAME_OF_TABLE = "'KD_POK_BRIS'";

    private static final String GET_INFO_FROM_KD_POK_BRIS_DIRECTORY_SQL = "SELECT * FROM KD_POK_BRIS";
    private static final String INSERT_INFO_INTO_KD_POK_BRIS_DIRECTORY_SQL = "INSERT INTO KD_POK_BRIS (CODE,NAME,LIST_KD_PRODUCTS,CHECK_TOPPDN_REZERV,RESERVE_PERSENT_FOR_KD) VALUES (?,?,?,?,?)";
    private static final String UPDATE_INFO_INTO_KD_POK_BRIS_DIRECTORY_SQL = "UPDATE KD_POK_BRIS SET CODE = ?,NAME = ?,LIST_KD_PRODUCTS = ?,CHECK_TOPPDN_REZERV = ?,RESERVE_PERSENT_FOR_KD = ? WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_KD_POK_BRIS_DIRECTORY_SQL = "DELETE FROM KD_POK_BRIS WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public KdPokBrisRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_KD_POK_BRIS_DIRECTORY_SQL, new BeanPropertyRowMapper<>(KdPokBris.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(KdPokBris kdPokBris) {
        jdbcTemplate.update(UPDATE_INFO_INTO_KD_POK_BRIS_DIRECTORY_SQL,
                kdPokBris.getCode(),
                kdPokBris.getName(),
                kdPokBris.getListKdProducts(),
                kdPokBris.getCheckToppdnRezerv(),
                kdPokBris.getReservePersentForKd(),
                kdPokBris.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_KD_POK_BRIS_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(KdPokBris kdPokBris) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_KD_POK_BRIS_DIRECTORY_SQL,
                kdPokBris.getCode(),
                kdPokBris.getName(),
                kdPokBris.getListKdProducts(),
                kdPokBris.getCheckToppdnRezerv(),
                kdPokBris.getReservePersentForKd()
        );
        return true;
    }
}
