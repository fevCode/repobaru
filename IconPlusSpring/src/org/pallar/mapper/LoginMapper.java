package org.pallar.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.pallar.model.Login;
import org.springframework.jdbc.core.RowMapper;

public class LoginMapper implements RowMapper<Login> {
	 public static final String BASE_SQL = //
	            "Select d.username,d.password "//
	                    + " from login d ";
	 
	    @Override
	    public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
	       //Integer deptId = rs.getInt("dept_id");
	        String username = rs.getString("username");
	        String password = rs.getString("password");
	       
	 
	        return new Login(username,password);
	    }
	 
}
