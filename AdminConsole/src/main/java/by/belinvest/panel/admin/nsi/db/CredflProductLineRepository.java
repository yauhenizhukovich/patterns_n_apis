package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.dep_product_line.DepProductLine;
import by.belinvest.panel.admin.entity.nsi.depfl_product_line.DepflProductLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class CredflProductLineRepository {

    private static final String GET_INFO_FROM_DEPFL_PRODUCT_LINE_DIRECTORY_SQL = "select * from credfl_product_line";
    private static final String UPDATE_INFO_INTO_DEP_PRODUCT_LINE_DIRECTORY_SQL = "UPDATE credfl_product_line SET NAME = ? WHERE CODE = ?";
    private static final String DELETE_INFO_FROM_DEP_PRODUCT_LINE_DIRECTORY_SQL = "DELETE FROM credfl_product_line where code = ?";
    private static final String GET_BPCARD_SQL = "select * from bpcard";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;
    private JdbcTemplate jdbcTemplateCatalog;
    private SimpleJdbcInsert simpleJdbcInsert;


    @Autowired
    public CredflProductLineRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository,
                                      @Qualifier("catalogDatasource") DataSource dataSourceCatalog) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbcTemplateCatalog = new JdbcTemplate(dataSourceCatalog);
        this.commentRepository = commentRepository;
        this.simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("credfl_product_line").usingGeneratedKeyColumns("code");
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_DEPFL_PRODUCT_LINE_DIRECTORY_SQL, new BeanPropertyRowMapper<>(DepflProductLine.class)));
        //directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean create(DepProductLine depProductLine, String nsiId) {

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", depProductLine.getName());

        Number idD = simpleJdbcInsert.executeAndReturnKey(params);

        //запись в промежуточную таблицу bp_product_line
        jdbcTemplateCatalog.execute("INSERT INTO BP_PRODUCT_LINE  VALUES (" + Integer.parseInt(nsiId) + " ,'CREDFL_PRODUCT_LINE'," + idD.longValue() + ")");
        return true;
    }

    public boolean update(DepProductLine depProductLine) {
        if (!depProductLine.getIdCard().isEmpty()) {
            jdbcTemplate.update("UPDATE credfl_product_line SET NAME = '" + depProductLine.getName() + "' WHERE CODE = " + depProductLine.getCode() + "");
            jdbcTemplateCatalog.update("update bp_product_line set bpid=" + Integer.valueOf(depProductLine.getIdCard()) + " where NSI_NAME='CREDFL_PRODUCT_LINE' and NSI_ID = " + depProductLine.getCode());
        }

        return true;
    }

    public boolean remove(String code) {
        jdbcTemplate.update(DELETE_INFO_FROM_DEP_PRODUCT_LINE_DIRECTORY_SQL, code);
        jdbcTemplateCatalog.update("DELETE FROM bp_product_line where NSI_NAME='CREDFL_PRODUCT_LINE' and NSI_ID = "+code);
        return true;
    }
}
