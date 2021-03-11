package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.balans2.Balans2;
import by.belinvest.panel.admin.entity.nsi.balans2.Balans2Directory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

@Repository
public class Balans2Repository {

    private static final String GET_INFO_FROM_BALANS2_DIRECTORY_SQL = "select ROWID, DIMID, SCODE1, SCODE2, SCODE3, SCODE4, NAME, ACC_A_P, ACC_O_C, ACC_P_N, AUDIT_CODE, BL_CL_BANK, BL_DEFAULT, BL_FORM_NAME, BL_NO, BL_REQU, CA_O_C, RA_O_C, CLOSE FROM BALANS2 ORDER BY NAME";
    private static final String INSERT_INFO_INTO_BALANS2_DIRECTORY_SQL = "INSERT INTO BALANS2 (DIMID, SCODE1, SCODE2, SCODE3, SCODE4, NAME, ACC_A_P, ACC_O_C, ACC_P_N, AUDIT_CODE, BL_CL_BANK, BL_DEFAULT, BL_FORM_NAME, BL_NO, BL_REQU, CA_O_C, RA_O_C, CLOSE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_INFO_INTO_BALANS2_DIRECTORY_SQL = "UPDATE BALANS2 SET DIMID = ?, SCODE1 = ?, SCODE2 = ?, SCODE3 = ?, SCODE4 = ?, NAME = ?, ACC_A_P = ?, ACC_O_C = ?, ACC_P_N = ?, AUDIT_CODE = ?, BL_CL_BANK = ?, BL_DEFAULT = ?, BL_FORM_NAME = ?, BL_NO = ?, BL_REQU = ?, CA_O_C = ?, RA_O_C = ?, CLOSE = ? WHERE ROWID = ?";
    private static final String DELETE_INFO_FROM_BALANS2_DIRECTORY_SQL = "DELETE FROM BALANS2 WHERE ROWID = ?";

    private static final int ID_COLUMN = 1;
    private static final int DIM_ID_COLUMN = 2;
    private static final int SCODE_1_COLUMN = 3;
    private static final int SCODE_2_COLUMN = 4;
    private static final int SCODE_3_COLUMN = 5;
    private static final int SCODE_4_COLUMN = 6;
    private static final int NAME_COLUMN = 7;
    private static final int ACC_AP_RANG_COLUMN = 8;
    private static final int ACC_OC_KOD_GB_COLUMN = 9;
    private static final int ACC_PN_KOD_AUTU_COLUMN = 10;
    private static final int AUDIT_CODE_COLUMN = 11;
    private static final int BL_CL_BANK_COLUMN = 12;
    private static final int BL_DEFAULT_COLUMN = 13;
    private static final int BL_FORM_NAME_COLUMN = 14;
    private static final int BL_NO_COLUMN = 15;
    private static final int BL_REQU_COLUMN = 16;
    private static final int CA_OC_COLUMN = 17;
    private static final int RA_OC_COLUMN = 18;
    private static final int CLOSE_COLUMN = 19;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public Balans2Repository(@Qualifier("nsiDatasource") DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Balans2Directory get() {
        Balans2Directory balans2Directory = new Balans2Directory();
        jdbcTemplate.query(GET_INFO_FROM_BALANS2_DIRECTORY_SQL, rs -> {
            parseDescription(balans2Directory, rs.getMetaData());
            while (rs.next()) {
                balans2Directory.getBalanses().add(parseBalans2(rs));
            }
        });

        return balans2Directory;
    }

    public boolean update(Balans2 balans2) {
        jdbcTemplate.update(UPDATE_INFO_INTO_BALANS2_DIRECTORY_SQL,
                balans2.getDimId(),
                balans2.getScode1(),
                balans2.getScode2(),
                balans2.getScode3(),
                balans2.getScode4(),
                balans2.getName(),
                balans2.getAccAp(),
                balans2.getAccOc(),
                balans2.getAccPn(),
                balans2.getAuditCode(),
                balans2.getBlClBank(),
                balans2.getBlDefault(),
                balans2.getBlFormName(),
                balans2.getBlNo(),
                balans2.getBlRequ(),
                balans2.getCaOc(),
                balans2.getRaOc(),
                balans2.getClose(),
                balans2.getId()
        );
        return true;
    }

    public boolean remove(String rowId) {
        jdbcTemplate.update(DELETE_INFO_FROM_BALANS2_DIRECTORY_SQL, rowId);
        return true;
    }

    public boolean create(Balans2 balans2) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_BALANS2_DIRECTORY_SQL,
                balans2.getDimId(),
                balans2.getScode1(),
                balans2.getScode2(),
                balans2.getScode3(),
                balans2.getScode4(),
                balans2.getName(),
                balans2.getAccAp(),
                balans2.getAccOc(),
                balans2.getAccPn(),
                balans2.getAuditCode(),
                balans2.getBlClBank(),
                balans2.getBlDefault(),
                balans2.getBlFormName(),
                balans2.getBlNo(),
                balans2.getBlRequ(),
                balans2.getCaOc(),
                balans2.getRaOc(),
                balans2.getClose()
        );
        return true;
    }

    private Balans2 parseBalans2(ResultSet rs) throws SQLException {
        return new Balans2(
                rs.getString(ID_COLUMN),
                rs.getString(DIM_ID_COLUMN),
                rs.getString(SCODE_1_COLUMN),
                rs.getString(SCODE_2_COLUMN),
                rs.getString(SCODE_3_COLUMN),
                rs.getString(SCODE_4_COLUMN),
                rs.getString(NAME_COLUMN),
                rs.getString(ACC_AP_RANG_COLUMN),
                rs.getString(ACC_OC_KOD_GB_COLUMN),
                rs.getString(ACC_PN_KOD_AUTU_COLUMN),
                rs.getString(AUDIT_CODE_COLUMN),
                rs.getString(BL_CL_BANK_COLUMN),
                rs.getString(BL_DEFAULT_COLUMN),
                rs.getString(BL_FORM_NAME_COLUMN),
                rs.getString(BL_NO_COLUMN),
                rs.getString(BL_REQU_COLUMN),
                rs.getString(CA_OC_COLUMN),
                rs.getString(RA_OC_COLUMN),
                rs.getString(CLOSE_COLUMN)
        );
    }

    private void parseDescription(Balans2Directory balans2Directory, ResultSetMetaData rsmd) throws SQLException {
        balans2Directory.setDimIdDescription(rsmd.getColumnLabel(DIM_ID_COLUMN));
        balans2Directory.setScode1Description(rsmd.getColumnName(SCODE_1_COLUMN));
        balans2Directory.setScode2Description(rsmd.getColumnName(SCODE_2_COLUMN));
        balans2Directory.setScode3Description(rsmd.getColumnName(SCODE_3_COLUMN));
        balans2Directory.setScode4Description(rsmd.getColumnName(SCODE_4_COLUMN));
        balans2Directory.setNameDescription(rsmd.getColumnName(NAME_COLUMN));
        balans2Directory.setAccApDescription(rsmd.getColumnName(ACC_AP_RANG_COLUMN));
        balans2Directory.setAccOcDescription(rsmd.getColumnName(ACC_OC_KOD_GB_COLUMN));
        balans2Directory.setAccPnDescription(rsmd.getColumnName(ACC_PN_KOD_AUTU_COLUMN));
        balans2Directory.setAuditCodeDescription(rsmd.getColumnName(AUDIT_CODE_COLUMN));
        balans2Directory.setBlClBankDescription(rsmd.getColumnName(BL_CL_BANK_COLUMN));
        balans2Directory.setBlDefaultDescription(rsmd.getColumnName(BL_DEFAULT_COLUMN));
        balans2Directory.setBlFormNameDescription(rsmd.getColumnName(BL_FORM_NAME_COLUMN));
        balans2Directory.setBlNoDescription(rsmd.getColumnName(BL_NO_COLUMN));
        balans2Directory.setBlRequDescription(rsmd.getColumnName(BL_REQU_COLUMN));
        balans2Directory.setCaOcDescription(rsmd.getColumnName(CA_OC_COLUMN));
        balans2Directory.setRaOcDescription(rsmd.getColumnName(RA_OC_COLUMN));
        balans2Directory.setCloseDescription(rsmd.getColumnName(CLOSE_COLUMN));

    }
}