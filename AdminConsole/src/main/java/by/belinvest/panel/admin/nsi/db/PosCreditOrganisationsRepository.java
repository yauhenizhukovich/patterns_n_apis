package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.pos_credit_organisations.PosCreditOrganisations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class PosCreditOrganisationsRepository {
    private static final String NAME_OF_TABLE = "'POS_KREDIT_ORGANISATIONS'";

    private static final String GET_INFO_FROM_POS_KREDIT_ORGANISATIONS_DIRECTORY_SQL = "SELECT * FROM POS_KREDIT_ORGANISATIONS";
    private static final String INSERT_INFO_INTO_POS_KREDIT_ORGANISATIONS_DIRECTORY_SQL = "INSERT INTO POS_KREDIT_ORGANISATIONS (PARENTID,CODE,NAME,PKO_NAME,PKO_ADRESS,PKO_UNP,PKO_BANKS,PKO_ACCOUNT,PKO_BANKS_POS,PKO_NAME_TT,PKO_ADRESS_TT,PKO_UNP_TT,PKO_BANKS_TT,PKO_ACCOUNT_TT) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE_INFO_INTO_POS_KREDIT_ORGANISATIONS_DIRECTORY_SQL = "UPDATE POS_KREDIT_ORGANISATIONS SET PARENTID = ?,CODE = ?,NAME = ?,PKO_NAME = ?,PKO_ADRESS = ?,PKO_UNP = ?,PKO_BANKS = ?,PKO_ACCOUNT = ?,PKO_BANKS_POS = ?,PKO_NAME_TT = ?,PKO_ADRESS_TT = ?,PKO_UNP_TT = ?,PKO_BANKS_TT = ?,PKO_ACCOUNT_TT = ? WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_POS_KREDIT_ORGANISATIONS_DIRECTORY_SQL = "DELETE FROM POS_KREDIT_ORGANISATIONS WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PosCreditOrganisationsRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_POS_KREDIT_ORGANISATIONS_DIRECTORY_SQL, new BeanPropertyRowMapper<>(PosCreditOrganisations.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(PosCreditOrganisations posCreditOrganisations) {
        jdbcTemplate.update(UPDATE_INFO_INTO_POS_KREDIT_ORGANISATIONS_DIRECTORY_SQL,
                posCreditOrganisations.getParentId(),
                posCreditOrganisations.getCode(),
                posCreditOrganisations.getName(),
                posCreditOrganisations.getPkoName(),
                posCreditOrganisations.getPkoAdress(),
                posCreditOrganisations.getPkoUnp(),
                posCreditOrganisations.getPkoBanks(),
                posCreditOrganisations.getPkoAccount(),
                posCreditOrganisations.getPkoBankPos(),
                posCreditOrganisations.getPkoNameTt(),
                posCreditOrganisations.getPkoAdressTt(),
                posCreditOrganisations.getPkoUnpTt(),
                posCreditOrganisations.getPkoBanksTt(),
                posCreditOrganisations.getPkoAccountTt(),
                posCreditOrganisations.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_POS_KREDIT_ORGANISATIONS_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(PosCreditOrganisations posCreditOrganisations) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_POS_KREDIT_ORGANISATIONS_DIRECTORY_SQL,
                posCreditOrganisations.getParentId(),
                posCreditOrganisations.getCode(),
                posCreditOrganisations.getName(),
                posCreditOrganisations.getPkoName(),
                posCreditOrganisations.getPkoAdress(),
                posCreditOrganisations.getPkoUnp(),
                posCreditOrganisations.getPkoBanks(),
                posCreditOrganisations.getPkoAccount(),
                posCreditOrganisations.getPkoBankPos(),
                posCreditOrganisations.getPkoNameTt(),
                posCreditOrganisations.getPkoAdressTt(),
                posCreditOrganisations.getPkoUnpTt(),
                posCreditOrganisations.getPkoBanksTt(),
                posCreditOrganisations.getPkoAccountTt()
        );
        return true;
    }
}
