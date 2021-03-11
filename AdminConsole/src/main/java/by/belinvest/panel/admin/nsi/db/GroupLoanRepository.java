package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.group_loan.GroupLoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class GroupLoanRepository {
    private static final String NAME_OF_TABLE = "'GROUP_LOAN'";

    private static final String GET_INFO_FROM_GROUP_LOAN_DIRECTORY_SQL = "SELECT * FROM GROUP_LOAN";
    private static final String INSERT_INFO_INTO_GROUP_LOAN_DIRECTORY_SQL = "INSERT INTO GROUP_LOAN (PARENTID,CODE,NAME) VALUES (?,?,?)";
    private static final String UPDATE_INFO_INTO_GROUP_LOAN_DIRECTORY_SQL = "UPDATE GROUP_LOAN SET PARENTID = ?,CODE = ?,NAME = ? WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_GROUP_LOAN_DIRECTORY_SQL = "DELETE FROM GROUP_LOAN WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public GroupLoanRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_GROUP_LOAN_DIRECTORY_SQL, new BeanPropertyRowMapper<>(GroupLoan.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(GroupLoan groupLoan) {
        jdbcTemplate.update(UPDATE_INFO_INTO_GROUP_LOAN_DIRECTORY_SQL,
                groupLoan.getParentId(),
                groupLoan.getCode(),
                groupLoan.getName(),
                groupLoan.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_GROUP_LOAN_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(GroupLoan groupLoan) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_GROUP_LOAN_DIRECTORY_SQL,
                groupLoan.getParentId(),
                groupLoan.getCode(),
                groupLoan.getName()
        );
        return true;
    }
}
