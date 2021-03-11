package by.belinvest.panel.admin.audit.db.refresh_nsi;


import by.belinvest.panel.admin.nsi.db.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.object.GenericStoredProcedure;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

@Repository
public class RefreshNsiRepository {

    public static final String REFRESH_PROCEDURE = "CALL refresh";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RefreshNsiRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }


    public void refreshNsi(){
        StoredProcedure procedure = new GenericStoredProcedure();
        procedure.setDataSource(jdbcTemplate.getDataSource());
        procedure.setSql("nsi.utl_nsi.refresh");
        procedure.setFunction(false);

        procedure.compile();
        Map<String, Object> result = procedure.execute();
    }

}
