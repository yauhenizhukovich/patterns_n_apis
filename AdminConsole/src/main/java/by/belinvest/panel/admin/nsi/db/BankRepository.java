package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.bank.Bank;
import by.belinvest.panel.admin.entity.nsi.bank.BankDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

@Repository
public class BankRepository {

    private static final String GET_INFO_FROM_BANK_DIRECTORY_SQL = "SELECT ROWID, CODE, NAME, BANKS_PRYAM, BANKS_REGION, BANKS_OLD_CODE, BANKS_BICISO, BANKS_RANG, BANKS_KOD_GB, BANKS_KOD_AUTU, BANKS_ADDRESS, BANKS_KOD_TYPE, BANKS_KOD_SOATO, BANKS_KOD_STATU, BANKS_PHONE FROM BANKS ORDER BY NAME";
    private static final String INSERT_INFO_INTO_BANK_DIRECTORY_SQL = "INSERT INTO BANKS (CODE, NAME, BANKS_PRYAM, BANKS_REGION, BANKS_OLD_CODE, BANKS_BICISO, BANKS_RANG, BANKS_KOD_GB, BANKS_KOD_AUTU, BANKS_ADDRESS, BANKS_KOD_TYPE, BANKS_KOD_SOATO, BANKS_KOD_STATU, BANKS_PHONE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_INFO_INTO_BANK_DIRECTORY_SQL = "UPDATE BANKS SET CODE = ?, NAME = ?, BANKS_PRYAM = ?, BANKS_REGION = ?, BANKS_OLD_CODE = ?, BANKS_BICISO = ?, BANKS_RANG = ?, BANKS_KOD_GB = ?, BANKS_KOD_AUTU = ?, BANKS_ADDRESS = ?, BANKS_KOD_TYPE = ?, BANKS_KOD_SOATO = ?, BANKS_KOD_STATU = ?, BANKS_PHONE = ? WHERE ROWID = ?";
    private static final String DELETE_INFO_FROM_BANK_DIRECTORY_SQL = "DELETE FROM BANKS WHERE ROWID = ?";

    private static final int ID_COLUMN = 1;
    private static final int CODE_COLUMN = 2;
    private static final int NAME_COLUMN = 3;
    private static final int BANKS_PRYAM_COLUMN = 4;
    private static final int BANKS_REGION_COLUMN = 5;
    private static final int BANKS_OLD_CODE_COLUMN = 6;
    private static final int BANKS_BICISO_COLUMN = 7;
    private static final int BANKS_RANG_COLUMN = 8;
    private static final int BANKS_KOD_GB_COLUMN = 9;
    private static final int BANKS_KOD_AUTU_COLUMN = 10;
    private static final int BANKS_ADDRESS_COLUMN = 11;
    private static final int BANKS_KOD_TYPE_COLUMN = 12;
    private static final int BANKS_KOD_SOATO_COLUMN = 13;
    private static final int BANKS_KOD_STATU_COLUMN = 14;
    private static final int BANKS_PHONE_COLUMN = 15;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BankRepository(@Qualifier("nsiDatasource") DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public BankDirectory get() {
        BankDirectory bankDirectory = new BankDirectory();
        jdbcTemplate.query(GET_INFO_FROM_BANK_DIRECTORY_SQL, rs -> {

            parseDescription(bankDirectory, rs.getMetaData());
            while (rs.next()) {
                bankDirectory.getBanks().add(parseBank(rs));
            }
        });

        return bankDirectory;
    }

    public boolean update(Bank bank) {
        jdbcTemplate.update(UPDATE_INFO_INTO_BANK_DIRECTORY_SQL,
                bank.getCode(),
                bank.getName(),
                bank.getBanksPryam(),
                bank.getBanksRegion(),
                bank.getBanksOldCode(),
                bank.getBanksBiciso(),
                bank.getBanksRang(),
                bank.getBanksKodGb(),
                bank.getBanksKodAutu(),
                bank.getBanksAddress(),
                bank.getBanksKodType(),
                bank.getBanksKodSoato(),
                bank.getBanksKodStatu(),
                bank.getBanksPhone(),
                bank.getId());
        return true;
    }

    public boolean remove(String rowId) {
        jdbcTemplate.update(DELETE_INFO_FROM_BANK_DIRECTORY_SQL, rowId);
        return true;
    }

    public boolean create(Bank bank) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_BANK_DIRECTORY_SQL,
                bank.getCode(),
                bank.getName(),
                bank.getBanksPryam(),
                bank.getBanksRegion(),
                bank.getBanksOldCode(),
                bank.getBanksBiciso(),
                bank.getBanksRang(),
                bank.getBanksKodGb(),
                bank.getBanksKodAutu(),
                bank.getBanksAddress(),
                bank.getBanksKodType(),
                bank.getBanksKodSoato(),
                bank.getBanksKodStatu(),
                bank.getBanksPhone()
        );
        return true;
    }

    private Bank parseBank(ResultSet rs) throws SQLException {
        return new Bank(
                rs.getString(ID_COLUMN),
                rs.getString(CODE_COLUMN),
                rs.getString(NAME_COLUMN),
                rs.getString(BANKS_PRYAM_COLUMN),
                rs.getString(BANKS_REGION_COLUMN),
                rs.getString(BANKS_OLD_CODE_COLUMN),
                rs.getString(BANKS_BICISO_COLUMN),
                rs.getString(BANKS_RANG_COLUMN),
                rs.getString(BANKS_KOD_GB_COLUMN),
                rs.getString(BANKS_KOD_AUTU_COLUMN),
                rs.getString(BANKS_ADDRESS_COLUMN),
                rs.getString(BANKS_KOD_TYPE_COLUMN),
                rs.getString(BANKS_KOD_SOATO_COLUMN),
                rs.getString(BANKS_KOD_STATU_COLUMN),
                rs.getString(BANKS_PHONE_COLUMN)
        );
    }

    private void parseDescription(BankDirectory bankDirectory, ResultSetMetaData rsmd) throws SQLException {
        bankDirectory.setCodeDescription(rsmd.getColumnLabel(CODE_COLUMN));
        bankDirectory.setNameDescription(rsmd.getColumnName(NAME_COLUMN));
        bankDirectory.setBanksPryamDescription(rsmd.getColumnName(BANKS_PRYAM_COLUMN));
        bankDirectory.setBanksRegionDescription(rsmd.getColumnName(BANKS_REGION_COLUMN));
        bankDirectory.setBanksOldCodeDescription(rsmd.getColumnName(BANKS_OLD_CODE_COLUMN));
        bankDirectory.setBanksBicisoDescription(rsmd.getColumnName(BANKS_BICISO_COLUMN));
        bankDirectory.setBanksRangDescription(rsmd.getColumnName(BANKS_RANG_COLUMN));
        bankDirectory.setBanksKodGbDescription(rsmd.getColumnName(BANKS_KOD_GB_COLUMN));
        bankDirectory.setBanksKodAutuDescription(rsmd.getColumnName(BANKS_KOD_AUTU_COLUMN));
        bankDirectory.setBanksAddressDescription(rsmd.getColumnName(BANKS_ADDRESS_COLUMN));
        bankDirectory.setBanksKodTypeDescription(rsmd.getColumnName(BANKS_KOD_TYPE_COLUMN));
        bankDirectory.setBanksKodSoatoDescription(rsmd.getColumnName(BANKS_KOD_SOATO_COLUMN));
        bankDirectory.setBanksKodStatuDescription(rsmd.getColumnName(BANKS_KOD_STATU_COLUMN));
        bankDirectory.setBanksPhoneDescription(rsmd.getColumnName(BANKS_PHONE_COLUMN));

    }

}
