package by.belinvest.panel.admin.nsi.db;

import javax.sql.DataSource;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.dep_product_line.DepProductLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class DepProductLineRepository {

    private static final String NAME_OF_TABLE = "'DEP_PRODUCT_LINE'";

    private static final String GET_INFO_FROM_DEP_PRODUCT_LINE_DIRECTORY_SQL = "SELECT * FROM DEP_PRODUCT_LINE";
    private static final String INSERT_INFO_INTO_DEP_PRODUCT_LINE_DIRECTORY_SQL = "INSERT INTO DEP_PRODUCT_LINE (NAME) VALUES (?)";
    private static final String UPDATE_INFO_INTO_DEP_PRODUCT_LINE_DIRECTORY_SQL = "UPDATE DEP_PRODUCT_LINE SET NAME = ? WHERE CODE = ?";
    private static final String DELETE_INFO_FROM_DEP_PRODUCT_LINE_DIRECTORY_SQL = "DELETE FROM DEP_PRODUCT_LINE WHERE CODE = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;
    private JdbcTemplate jdbcTemplateCatalog;
    private SimpleJdbcInsert simpleJdbcInsert;

    @Autowired
    public DepProductLineRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository
            , @Qualifier("catalogDatasource") DataSource dataSourceCatalog) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
        this.jdbcTemplateCatalog = new JdbcTemplate(dataSourceCatalog);
        this.simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("dep_product_line").usingGeneratedKeyColumns("code");
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_DEP_PRODUCT_LINE_DIRECTORY_SQL,
                new BeanPropertyRowMapper<>(DepProductLine.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(DepProductLine depProductLine) {
        jdbcTemplate.update(UPDATE_INFO_INTO_DEP_PRODUCT_LINE_DIRECTORY_SQL,
                depProductLine.getName(),
                depProductLine.getCode());
        return true;
    }

    public boolean remove(String code) {
        jdbcTemplate.update(DELETE_INFO_FROM_DEP_PRODUCT_LINE_DIRECTORY_SQL, code);
        return true;
    }

    public boolean create(DepProductLine depProductLine, String nsiId) {

        System.out.println(depProductLine.getName());
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", depProductLine.getName());

        //создание ID
        Number idD = simpleJdbcInsert.executeAndReturnKey(params);
        //запись в промежуточную таблицу bp_product_line
        String v = "INSERT INTO BP_PRODUCT_LINE  VALUES (" + Integer.parseInt(nsiId) + " ,'DEP_PRODUCT_LINE'," + idD + ")";
        System.out.println(v);
        jdbcTemplateCatalog.execute(v);
        return true;
    }

}
