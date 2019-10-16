package org.pallar.mapper;
 
import java.sql.ResultSet;
import java.sql.SQLException;
 


import org.pallar.model.Department;
import org.pallar.model.Mahasiswa;
import org.springframework.jdbc.core.RowMapper;
 
public class MahasiswaMapper implements RowMapper<Mahasiswa> {
 
    public static final String BASE_SQL = //
            "Select d.IDMahasiswa,d.namaMahasiswa,d.dept_no "//
                    + " from Mahasiswa d ";
 
    @Override
    public Mahasiswa mapRow(ResultSet rs, int rowNum) throws SQLException {
       //Integer deptId = rs.getInt("dept_id");
        String IDMahasiswa = rs.getString("IDMahasiswa");
        String namaMahasiswa = rs.getString("namaMahasiswa");
        String dept_no = rs.getString("dept_no");
 
        return new Mahasiswa(IDMahasiswa, namaMahasiswa, dept_no);
    }
 
}