package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.kd_prod_prog.KdProdProg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class KdProdProgRepository {

    private static final String NAME_OF_TABLE = "'KD_PROD_PROG'";

    private static final String GET_INFO_FROM_KD_PROD_PROG_DIRECTORY_SQL = "SELECT * FROM KD_PROD_PROG";
    private static final String INSERT_INFO_INTO_KD_PROD_PROG_DIRECTORY_SQL = "INSERT INTO KD_PROD_PROG (CODE,NAME,KD_PP_ST_RISK,KD_PP_TARG,KD_PP_RM_DEC,KD_PP_COND_OBLIG,KD_PP_PROD,KD_PP_TYPE,KD_PP_PENYA_VAL,KD_PP_CUR_CLIENT,KD_PP_FORM,KD_PP_VID_OBES,KD_PP_IST_FIN,KD_PP_DOST,KD_PP_CUR_BANK,KD_PP_MICRO,KD_PP_OBOR,KD_PP_TARIF,KD_PP_TYPE_KR,KD_PP_TERM,KD_PP_DAYS_IN_Y) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE_INFO_INTO_KD_PROD_PROG_DIRECTORY_SQL = "UPDATE KD_PROD_PROG SET CODE = ?,NAME = ?,KD_PP_ST_RISK = ?,KD_PP_TARG = ?,KD_PP_RM_DEC = ?,KD_PP_COND_OBLIG = ?,KD_PP_PROD = ?,KD_PP_TYPE = ?,KD_PP_PENYA_VAL = ?,KD_PP_CUR_CLIENT = ?,KD_PP_FORM = ?,KD_PP_VID_OBES = ?,KD_PP_IST_FIN = ?,KD_PP_DOST = ?,KD_PP_CUR_BANK = ?,KD_PP_MICRO = ?,KD_PP_OBOR = ?,KD_PP_TARIF = ?,KD_PP_TYPE_KR = ?,KD_PP_TERM = ?,KD_PP_DAYS_IN_Y = ? WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_KD_PROD_PROG_DIRECTORY_SQL = "DELETE FROM KD_PROD_PROG WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public KdProdProgRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_KD_PROD_PROG_DIRECTORY_SQL, new BeanPropertyRowMapper<>(KdProdProg.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(KdProdProg kdProdProg) {
        jdbcTemplate.update(UPDATE_INFO_INTO_KD_PROD_PROG_DIRECTORY_SQL,
                kdProdProg.getCode(),
                kdProdProg.getName(),
                kdProdProg.getKdPpStRisk(),
                kdProdProg.getKdPpTarg(),
                kdProdProg.getKdPpRmDec(),
                kdProdProg.getKdPpCondOblig(),
                kdProdProg.getKdPpProd(),
                kdProdProg.getKdPpType(),
                kdProdProg.getKdPpPenyaVal(),
                kdProdProg.getKdPpCurClient(),
                kdProdProg.getKdPpCurForm(),
                kdProdProg.getKdPpVidObes(),
                kdProdProg.getKdPpIstFin(),
                kdProdProg.getKdPpDost(),
                kdProdProg.getKdPpCurBank(),
                kdProdProg.getKdPpMicro(),
                kdProdProg.getKdPpObor(),
                kdProdProg.getKdPpTarif(),
                kdProdProg.getKdPpType(),
                kdProdProg.getKdPpTerm(),
                kdProdProg.getKdPPDaysInY(),
                kdProdProg.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_KD_PROD_PROG_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(KdProdProg kdProdProg) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_KD_PROD_PROG_DIRECTORY_SQL,
                kdProdProg.getCode(),
                kdProdProg.getName(),
                kdProdProg.getKdPpStRisk(),
                kdProdProg.getKdPpTarg(),
                kdProdProg.getKdPpRmDec(),
                kdProdProg.getKdPpCondOblig(),
                kdProdProg.getKdPpProd(),
                kdProdProg.getKdPpType(),
                kdProdProg.getKdPpPenyaVal(),
                kdProdProg.getKdPpCurClient(),
                kdProdProg.getKdPpCurForm(),
                kdProdProg.getKdPpVidObes(),
                kdProdProg.getKdPpIstFin(),
                kdProdProg.getKdPpDost(),
                kdProdProg.getKdPpCurBank(),
                kdProdProg.getKdPpMicro(),
                kdProdProg.getKdPpObor(),
                kdProdProg.getKdPpTarif(),
                kdProdProg.getKdPpType(),
                kdProdProg.getKdPpTerm(),
                kdProdProg.getKdPPDaysInY()
        );
        return true;
    }
}
