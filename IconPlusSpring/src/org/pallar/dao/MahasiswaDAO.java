package org.pallar.dao;

import java.util.List;

import javax.sql.DataSource;

import org.pallar.mapper.MahasiswaMapper;
import org.pallar.model.Mahasiswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class MahasiswaDAO extends JdbcDaoSupport implements MahasiswaDAOImplement {

	@Autowired
	public MahasiswaDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	@Override
	public void insertMahasiswa(String IDMahasiswa, String namaMahasiswa, String dept_no) {
		String sql = "Insert into Mahasiswa (IDMahasiswa,namaMahasiswa,dept_no) "//
				+ " values (?,?,?) ";
		

		Object[] params = new Object[] { IDMahasiswa, namaMahasiswa, dept_no };
		this.getJdbcTemplate().update(sql, params);
	}

	@Override
	public int getMaxDeptId() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Mahasiswa findMahasiswa(String IDMahasiswa) {
	
		   String sql =MahasiswaMapper.BASE_SQL //
	                + " where d.IDMahasiswa = ?";

	        Object[] params = new Object[]{IDMahasiswa};

	        MahasiswaMapper mapper = new MahasiswaMapper();

	        Mahasiswa dos = this.getJdbcTemplate().queryForObject(sql, params, mapper);
	        return dos;
	}
	
	@Override
	public void updateMahasiswa(String IDMahasiswa, String namaMahasiswa, String dept_no) {
	
		   String sql ="UPDATE Mahasiswa SET namaMahasiswa = ?, dept_no=?  WHERE IDMahasiswa = ?";

	        Object[] params = new Object[]{namaMahasiswa,dept_no, IDMahasiswa};


	       int rows = this.getJdbcTemplate().update(sql, params);
	       System.out.println(rows + " row(s) updated.");
	}

	@Override
	public List<Mahasiswa> listMahasiswa() {
		String sql = MahasiswaMapper.BASE_SQL;

		Object[] params = new Object[] {};
		MahasiswaMapper mapper = new MahasiswaMapper();

		List<Mahasiswa> list = this.getJdbcTemplate().query(sql, params, mapper);
		return list;
	}
	@Override
	public void deleteMahasiswa(String IDMahasiswa) {
		 Object[] params = { IDMahasiswa };
		
	String deleteSql = "DELETE FROM Mahasiswa WHERE IDMahasiswa = ?";
		 int rows =  this.getJdbcTemplate().update(deleteSql, params);
		 System.out.println(rows + " row(s) deleted.");
	}

}
