package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.predst_bank.PredstBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class PredstBankRepository {
    private static final String NAME_OF_TABLE = "'PREDST_BANK'";

    private static final String GET_INFO_FROM_PREDST_BANK_DIRECTORY_SQL = "SELECT * FROM PREDST_BANK";
    private static final String INSERT_INFO_INTO_PREDST_BANK_DIRECTORY_SQL = "INSERT INTO PREDST_BANK (NAME,DOLJN_PREDST,POST_R,FIO_R_ACCESS,FIO_R,POST_R_ACCESS,MANAGER_PERSON_NUM,DOKUM_PREDST) VALUES (?,?,?,?,?,?,?,?)";
    private static final String UPDATE_INFO_INTO_PREDST_BANK_DIRECTORY_SQL = "UPDATE PREDST_BANK SET NAME = ?,DOLJN_PREDST = ?,POST_R = ?,FIO_R_ACCESS = ?,FIO_R = ?,POST_R_ACCESS = ?,MANAGER_PERSON_NUM = ?,DOKUM_PREDST = ?  WHERE CODE = ?";
    private static final String DELETE_INFO_FROM_PREDST_BANK_DIRECTORY_SQL = "DELETE FROM PREDST_BANK WHERE CODE = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PredstBankRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_PREDST_BANK_DIRECTORY_SQL, new BeanPropertyRowMapper<>(PredstBank.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(PredstBank predstBank) {
        jdbcTemplate.update(UPDATE_INFO_INTO_PREDST_BANK_DIRECTORY_SQL,
                predstBank.getName(),
                predstBank.getDoljnPredst(),
                predstBank.getPostR(),
                predstBank.getFioRAdress(),
                predstBank.getFioR(),
                predstBank.getPostRAccess(),
                predstBank.getManagerPersonNum(),
                predstBank.getDocumPredst(),
                predstBank.getCode());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_PREDST_BANK_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(PredstBank predstBank) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_PREDST_BANK_DIRECTORY_SQL,
                predstBank.getName(),
                predstBank.getDoljnPredst(),
                predstBank.getPostR(),
                predstBank.getFioRAdress(),
                predstBank.getFioR(),
                predstBank.getPostRAccess(),
                predstBank.getManagerPersonNum(),
                predstBank.getDocumPredst()
        );
        return true;
    }
}
