package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.Department;
import by.belinvest.panel.admin.entity.ViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DepartamentRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DepartamentRepository(@Qualifier("nsiDatasource") DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Department> getAllDepartments(){
       List<Department> list =  jdbcTemplate.query("select * from department where IS_DELETED=0",new DepartmentRowMapper());
       return list;
    }

    public void create(Department department) {
       jdbcTemplate.execute("insert into department values(SQ_DEPARTMENT.nextval,'"+department.getName()+"'," +
                "'"+department.getShortName()+"',"+Integer.parseInt(department.getfDevelop())+",'"+department.getHeadId()+"',"+department.getParentId()+",0,'"+department.getPost()+"')");

    }

    public void delete(Integer id){
        jdbcTemplate.execute("UPDATE DEPARTMENT SET IS_DELETED=1 WHERE DEP_ID="+id+"");
    }

    public void update(Department department) {
        jdbcTemplate.execute("update department set NAME='"+department.getName()+"'," +
                "SHORT_NAME='"+department.getShortName()+"'," +
                "F_DEVELOP="+Integer.parseInt(department.getfDevelop())+"," +
                "HEAD_ID='"+department.getHeadId()+"'," +
                "PARENT_ID="+department.getParentId()+"," +
                "IS_DELETED=0 WHERE DEP_ID="+department.getId()+"");
    }

    public boolean hasChildren(Long id) {
        List<Department> departments = jdbcTemplate.query("select * from department where parent_id ="+id+"",new DepartmentRowMapper());

        if (departments.isEmpty()){
            return false;
        }

        return true;
    }

    private static  class DepartmentRowMapper implements RowMapper<Department> {

        @Override
        public Department mapRow(ResultSet resultSet, int i) throws SQLException {
            Department department = new Department();
            department.setId(resultSet.getLong("DEP_ID"));
            department.setName(resultSet.getString("NAME"));
            department.setShortName(resultSet.getString("SHORT_NAME"));
            department.setfDevelop(String.valueOf(resultSet.getLong("F_DEVELOP")));
            department.setParentId(resultSet.getLong("PARENT_ID"));
            department.setHeadId(resultSet.getString("HEAD_ID"));
            department.setPost(resultSet.getString("POST"));
            return department;
        }
    }

}
