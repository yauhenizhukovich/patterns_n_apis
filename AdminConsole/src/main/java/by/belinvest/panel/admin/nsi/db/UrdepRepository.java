package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.urdep.Urdep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UrdepRepository {
    private static final String NAME_OF_TABLE = "'URDEP'";

    private static final String GET_INFO_FROM_URDEP_DIRECTORY_SQL = "SELECT * FROM URDEP";
    private static final String INSERT_INFO_INTO_URDEP_DIRECTORY_SQL = "INSERT INTO URDEP (PARENTID,CODE,NAME,DEP_PROC_DECREASE_STAV,DEP_VID_PROC_STAV,DEP_SUMBL,DEP_SROK,DEP_TYPE,DEP_SR_VOZVRAT,DEP_POROG_SUM,DEP_SUM_SPIS,DEP_MAX_SROK,DEP_STAV_SPIS,DEP_USL_RASTOR,DEP_BLOC,DEP_SUMDOG,DEP_ALLOW_ADDITION,DEP_BAN_DEYS,DEP_STAV_RAST,DEP_STAVKA,DEP_GOAL,DEP_SHKALA_STAV,DEP_KOL,DEP_TYPE_NACH_PROC,DEP_PROC_RAST,DEP_MAX_STAV,DEP_MAX_LIMIT,DEP_PROC_TAKE_ALLOW,DEP_MIN_SROK,DEP_STAV_RAST_VAL,DEP_SROK_WAIT_RETURN,DEP_LIMIT,DEP_TYPE_CONTRACT,DEP_ADDITIONAL_INCOME,DEP_KONTR_MAX_STAV,DEP_CURRENCY,DEP_STAV_POROG) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE_INFO_INTO_URDEP_DIRECTORY_SQL = "UPDATE URDEP SET PARENTID = ?,CODE = ?,NAME = ?,DEP_PROC_DECREASE_STAV = ?,DEP_VID_PROC_STAV = ?,DEP_SUMBL = ?,DEP_SROK = ?,DEP_TYPE = ?,DEP_SR_VOZVRAT = ?,DEP_POROG_SUM = ?,DEP_SUM_SPIS = ?,DEP_MAX_SROK = ?,DEP_STAV_SPIS = ?,DEP_USL_RASTOR = ?,DEP_BLOC = ?,DEP_SUMDOG = ?,DEP_ALLOW_ADDITION = ?,DEP_BAN_DEYS = ?,DEP_STAV_RAST = ?,DEP_STAVKA = ?,DEP_GOAL = ?,DEP_SHKALA_STAV = ?,DEP_KOL = ?,DEP_TYPE_NACH_PROC = ?,DEP_PROC_RAST = ?,DEP_MAX_STAV = ?,DEP_MAX_LIMIT = ?,DEP_PROC_TAKE_ALLOW = ?,DEP_MIN_SROK = ?,DEP_STAV_RAST_VAL = ?,DEP_SROK_WAIT_RETURN = ?,DEP_LIMIT = ?,DEP_TYPE_CONTRACT = ?,DEP_ADDITIONAL_INCOME = ?,DEP_KONTR_MAX_STAV = ?,DEP_CURRENCY = ?,DEP_STAV_POROG = ?  WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_URDEP_DIRECTORY_SQL = "DELETE FROM URDEP WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UrdepRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_URDEP_DIRECTORY_SQL, new BeanPropertyRowMapper<>(Urdep.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(Urdep urdep) {
        jdbcTemplate.update(UPDATE_INFO_INTO_URDEP_DIRECTORY_SQL,
                urdep.getParentId(),
                urdep.getCode(),
                urdep.getName(),
                urdep.getDecreaseStav(),
                urdep.getProdStav(),
                urdep.getDepSumbl(),
                urdep.getSrok(),
                urdep.getType(),
                urdep.getSrVozvrat(),
                urdep.getPorogSum(),
                urdep.getSumSpis(),
                urdep.getMaxSrok(),
                urdep.getStavSpis(),
                urdep.getUslRastor(),
                urdep.getBloc(),
                urdep.getSumdog(),
                urdep.getAllowAddition(),
                urdep.getBanDeys(),
                urdep.getStavRast(),
                urdep.getDepStavka(),
                urdep.getGoal(),
                urdep.getShkalaStav(),
                urdep.getKol(),
                urdep.getNachProc(),
                urdep.getProcRast(),
                urdep.getMaxStav(),
                urdep.getMaxLimit(),
                urdep.getTakeAllow(),
                urdep.getMinSrok(),
                urdep.getStavRastVal(),
                urdep.getSrokWaitReturn(),
                urdep.getLimit(),
                urdep.getContract(),
                urdep.getAdditionalIncome(),
                urdep.getKontrMaxStav(),
                urdep.getCurrency(),
                urdep.getStavPorog(),
                urdep.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_URDEP_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(Urdep urdep) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_URDEP_DIRECTORY_SQL,
                urdep.getParentId(),
                urdep.getCode(),
                urdep.getName(),
                urdep.getDecreaseStav(),
                urdep.getProdStav(),
                urdep.getDepSumbl(),
                urdep.getSrok(),
                urdep.getType(),
                urdep.getSrVozvrat(),
                urdep.getPorogSum(),
                urdep.getSumSpis(),
                urdep.getMaxSrok(),
                urdep.getStavSpis(),
                urdep.getUslRastor(),
                urdep.getBloc(),
                urdep.getSumdog(),
                urdep.getAllowAddition(),
                urdep.getBanDeys(),
                urdep.getStavRast(),
                urdep.getDepStavka(),
                urdep.getGoal(),
                urdep.getShkalaStav(),
                urdep.getKol(),
                urdep.getNachProc(),
                urdep.getProcRast(),
                urdep.getMaxStav(),
                urdep.getMaxLimit(),
                urdep.getTakeAllow(),
                urdep.getMinSrok(),
                urdep.getStavRastVal(),
                urdep.getSrokWaitReturn(),
                urdep.getLimit(),
                urdep.getContract(),
                urdep.getAdditionalIncome(),
                urdep.getKontrMaxStav(),
                urdep.getCurrency(),
                urdep.getStavPorog()
        );
        return true;
    }
}
