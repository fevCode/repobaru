package org.pallar.mapper;
 
import java.sql.ResultSet;
import java.sql.SQLException;
 


import org.pallar.model.Department;
import org.pallar.model.Dosen;
import org.springframework.jdbc.core.RowMapper;
 
public class DosenMapper implements RowMapper<Dosen> {
 
    public static final String BASE_SQL = //
            "Select d.IDDosen,d.namaDosen,d.dept_no "//
                    + " from Dosen d ";
 
    @Override
    public Dosen mapRow(ResultSet rs, int rowNum) throws SQLException {
       //Integer deptId = rs.getInt("dept_id");
        String IDDosen = rs.getString("IDDosen");
        String namaDosen = rs.getString("namaDosen");
        String dept_no = rs.getString("dept_no");
 
        return new Dosen(IDDosen, namaDosen, dept_no);
    }
 
}