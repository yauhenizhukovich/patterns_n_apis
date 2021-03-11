package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.spis_scan_doc.SpisScanDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class SpisScanDocRepository {

    private static final String NAME_OF_TABLE = "'SPIS_SCAN_DOC'";

    private static final String GET_INFO_FROM_SPIS_SCAN_DOC_DIRECTORY_SQL = "SELECT * FROM SPIS_SCAN_DOC";
    private static final String INSERT_INFO_INTO_SPIS_SCAN_DOC_DIRECTORY_SQL = "INSERT INTO SPIS_SCAN_DOC (PARENTID,CODE,NAME,SCAN_PAC,SCAN_TYPE,DZ_VID_ZAL,DZ_PREDMET,DZ_VID_OBESP) VALUES (?,?,?,?,?,?,?,?)";
    private static final String UPDATE_INFO_INTO_SPIS_SCAN_DOC_DIRECTORY_SQL = "UPDATE SPIS_SCAN_DOC SET PARENTID = ?, CODE = ?,NAME = ?, SCAN_PAC = ?,SCAN_TYPE = ?, DZ_VID_ZAL = ?,DZ_PREDMET = ?,DZ_VID_OBESP = ? WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_SPIS_SCAN_DOC_DIRECTORY_SQL = "DELETE FROM SPIS_SCAN_DOC WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SpisScanDocRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_SPIS_SCAN_DOC_DIRECTORY_SQL, new BeanPropertyRowMapper<>(SpisScanDoc.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(SpisScanDoc spisScanDoc) {
        jdbcTemplate.update(UPDATE_INFO_INTO_SPIS_SCAN_DOC_DIRECTORY_SQL,
                spisScanDoc.getParentid(),
                spisScanDoc.getCode(),
                spisScanDoc.getName(),
                spisScanDoc.getScanPac(),
                spisScanDoc.getScanType(),
                spisScanDoc.getDzVidZal(),
                spisScanDoc.getDzPredmet(),
                spisScanDoc.getDzVidObesp(),
                spisScanDoc.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_SPIS_SCAN_DOC_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(SpisScanDoc spisScanDoc) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_SPIS_SCAN_DOC_DIRECTORY_SQL,
                spisScanDoc.getParentid(),
                spisScanDoc.getCode(),
                spisScanDoc.getName(),
                spisScanDoc.getScanPac(),
                spisScanDoc.getScanType(),
                spisScanDoc.getDzVidZal(),
                spisScanDoc.getDzPredmet(),
                spisScanDoc.getDzVidObesp()
        );
        return true;
    }
}
