package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.LDAP.WlsLdapUser;
import by.belinvest.panel.admin.catalog.db.mappers.BPCardMapper;
import by.belinvest.panel.admin.entity.catalog.BPCard;
import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.dep_product_line.DepProductLine;
import by.belinvest.panel.admin.entity.nsi.depfl_product_line.DepflProductLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.support.AbstractContextMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class DepflProductLineRepository {
    private static final String NAME_OF_TABLE = "'DEPFL_PRODUCT_LINE'";

    private static final String GET_INFO_FROM_DEPFL_PRODUCT_LINE_DIRECTORY_SQL = "SELECT * FROM DEPFL_PRODUCT_LINE";
    private static final String INSERT_INFO_INTO_DEPFL_PRODUCT_LINE_DIRECTORY_SQL = "INSERT INTO DEPFL_PRODUCT_LINE (NAME) VALUES (?)";
    private static final String UPDATE_INFO_INTO_DEPFL_PRODUCT_LINE_DIRECTORY_SQL = "UPDATE DEPFL_PRODUCT_LINE SET NAME = ? WHERE CODE = ?";
    private static final String DELETE_INFO_FROM_DEPFL_PRODUCT_LINE_DIRECTORY_SQL = "DELETE FROM DEPFL_PRODUCT_LINE WHERE CODE = ?";

    private static final String GET_BPCARD_SQL = "select * from bpcard";


    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;
    private JdbcTemplate jdbcTemplateCatalog;
    private SimpleJdbcInsert simpleJdbcInsert;


    @Autowired
    public DepflProductLineRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository,
                                      @Qualifier("catalogDatasource") DataSource dataSourceCatalog) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbcTemplateCatalog = new JdbcTemplate(dataSourceCatalog);
        this.commentRepository = commentRepository;
        this.simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("depfl_product_line").usingGeneratedKeyColumns("code");
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_DEPFL_PRODUCT_LINE_DIRECTORY_SQL, new BeanPropertyRowMapper<>(DepflProductLine.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(DepflProductLine depflProductLine) {
        jdbcTemplate.update(UPDATE_INFO_INTO_DEPFL_PRODUCT_LINE_DIRECTORY_SQL,
                depflProductLine.getName(),
                depflProductLine.getCode());
        return true;
    }

    public boolean remove(String code) {
        jdbcTemplate.update(DELETE_INFO_FROM_DEPFL_PRODUCT_LINE_DIRECTORY_SQL, code);
        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean create(DepflProductLine depflProductLine, String nsiId) {

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", depflProductLine.getName());
        //создание ID
        Number idD = simpleJdbcInsert.executeAndReturnKey(params);

        String x = "INSERT INTO BP_PRODUCT_LINE  VALUES (" + Integer.parseInt(nsiId) + " ,'DEPFL_PRODUCT_LINE'," + idD + ")";

       //запись в промежуточную таблицу bp_product_line
       jdbcTemplateCatalog.execute(x);
        return true;
    }

    public List<BPCard> getBPCard() {
        List<Integer> list = jdbcTemplateCatalog.queryForList("SELECT BPID FROM BP_PRODUCT_LINE",Integer.class);
        List<BPCard> list1 = jdbcTemplateCatalog.query(GET_BPCARD_SQL, new BPCardMapper());


        list1.removeIf(bpCard ->
             list.contains(Integer.parseInt(bpCard.getbPId()))
        );

        return list1;
    }

    public List<BPCard> getBPCard2() {
        List<BPCard> list1 = jdbcTemplateCatalog.query(GET_BPCARD_SQL, new BPCardMapper());

        return list1;
    }

    public BPCard getBPCardById(String id) {
        List<Map<String,Object>> list = jdbcTemplateCatalog.queryForList("select * from bp_product_line WHERE NSI_ID ="+id);
        if (!list.isEmpty()){
            Map<String,Object> map = list.get(0);
            List<BPCard> list1 = jdbcTemplateCatalog.query("select * from bpcard where BPID=" + map.get("BPID"),new BPCardMapper());
            if (!list1.isEmpty()){
               return list1.get(0);
            }
        }
        return new BPCard();
    }


}
