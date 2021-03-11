package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.nsi_007.Nsi007;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class Nsi007Repository {
    private static final String NAME_OF_TABLE = "'NSI_007'";

    private static final String GET_INFO_FROM_NSI_007_DIRECTORY_SQL = "SELECT * FROM NSI_007";
    private static final String INSERT_INFO_INTO_NSI_007_DIRECTORY_SQL = "INSERT INTO NSI_007 (CODE,NAME,NAME_SWIFT,BORDER_STATE,RATING_VALUTA,CODE_SWIFT,RATING_NACVAL,SIGN_OESR,OFFSHOR_ZONE,SIGN_EU,SIGNS_CORRUPTION,HAZARDOUS_REGION,CODE_VALUTA,ISO_ALPHA3_CODE,GROUP_COUNTRY) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE_INFO_INTO_NSI_007_DIRECTORY_SQL = "UPDATE NSI_007 SET CODE = ?,NAME = ?,NAME_SWIFT = ?,BORDER_STATE = ?,RATING_VALUTA = ?,CODE_SWIFT = ?,RATING_NACVAL = ?,SIGN_OESR = ?,OFFSHOR_ZONE = ?,SIGN_EU = ?,SIGNS_CORRUPTION = ?,HAZARDOUS_REGION = ?,CODE_VALUTA = ?,ISO_ALPHA3_CODE = ?,GROUP_COUNTRY = ?  WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_NSI_007_DIRECTORY_SQL = "DELETE FROM NSI_007 WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public Nsi007Repository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_NSI_007_DIRECTORY_SQL, new BeanPropertyRowMapper<>(Nsi007.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(Nsi007 nsi007) {
        jdbcTemplate.update(UPDATE_INFO_INTO_NSI_007_DIRECTORY_SQL,
                nsi007.getCode(),
                nsi007.getName(),
                nsi007.getNameSwift(),
                nsi007.getBorderState(),
                nsi007.getRatingValuta(),
                nsi007.getCodeSwift(),
                nsi007.getRatingNacval(),
                nsi007.getSignOesr(),
                nsi007.getOffshorZone(),
                nsi007.getSignEu(),
                nsi007.getSignsCorruption(),
                nsi007.getHazardousRegion(),
                nsi007.getCodeValuta(),
                nsi007.getIsoAlpha3Code(),
                nsi007.getGroupCountry(),
                nsi007.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_NSI_007_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(Nsi007 nsi007) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_NSI_007_DIRECTORY_SQL,
                nsi007.getCode(),
                nsi007.getName(),
                nsi007.getNameSwift(),
                nsi007.getBorderState(),
                nsi007.getRatingValuta(),
                nsi007.getCodeSwift(),
                nsi007.getRatingNacval(),
                nsi007.getSignOesr(),
                nsi007.getOffshorZone(),
                nsi007.getSignEu(),
                nsi007.getSignsCorruption(),
                nsi007.getHazardousRegion(),
                nsi007.getCodeValuta(),
                nsi007.getIsoAlpha3Code(),
                nsi007.getGroupCountry()
        );
        return true;
    }
}
