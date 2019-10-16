package org.pallar.dao;

import java.util.List;

import javax.sql.DataSource;

import org.pallar.mapper.DepartmentMapper;
import org.pallar.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DepartmentDAO extends JdbcDaoSupport implements DepartmentDAOImplement {

   
    @Autowired
    public DepartmentDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    @Override
    public int getMaxDeptId() {
      /*  String sql = "Select max(d.dept_id) from Department d";

        Integer value = this.getJdbcTemplate().queryForObject(sql, Integer.class);
        if (value == null) {
            return 0;
        }
        return value;*/
    	return 0;
    }

    @Override
    public Department findDepartment(String deptNo) {

		   String sql =DepartmentMapper.BASE_SQL //
	                + " where d.DEPT_NO = ?";

	        Object[] params = new Object[]{deptNo};

	        DepartmentMapper mapper = new DepartmentMapper();

	        Department dep = this.getJdbcTemplate().queryForObject(sql, params, mapper);
	        return dep;
    }

    @Override
    public List<Department> listDepartment() {
        String sql = DepartmentMapper.BASE_SQL;

        Object[] params = new Object[]{};
        DepartmentMapper mapper = new DepartmentMapper();

        List<Department> list = this.getJdbcTemplate().query(sql, params, mapper);
        return list;
    }

    @Override
    public void insertDepartment(String deptNo,String deptName, String location) {
        String sql = "Insert into Department (DEPT_NO,DEPT_NAME,LOCATION) "//
                + " values (?,?,?) ";
       
        Object[] params = new Object[]{deptNo, deptName, location};
        this.getJdbcTemplate().update(sql, params);
    }

	@Override
	public void deleteDepartment(String DEPT_NO) {
		 Object[] params = { DEPT_NO };
		 // define SQL types of the arguments
	        //int[] types = {Types.BIGINT};
		 //String[] types = {Types.};
	String deleteSql = "DELETE FROM department WHERE DEPT_NO = ?";
		 int rows =  this.getJdbcTemplate().update(deleteSql, params);
		 System.out.println(rows + " row(s) deleted.");
		
	}

	@Override
	public void updateDepartment(String DEPT_NO, String DEPT_NAME, String LOCATION) {
		String sql ="UPDATE department SET DEPT_NAME = ?, LOCATION=?  WHERE DEPT_NO = ?";

        Object[] params = new Object[]{DEPT_NAME,LOCATION, DEPT_NO};


       int rows = this.getJdbcTemplate().update(sql, params);
       System.out.println(rows + " row(s) updated.");
		
	}
  
    
    
    

}
