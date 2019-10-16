package org.pallar.dao;

import java.util.List;

import javax.sql.DataSource;

import org.pallar.mapper.DosenMapper;
import org.pallar.model.Dosen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DosenDAO extends JdbcDaoSupport implements DosenDAOImplement {

	@Autowired
	public DosenDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	@Override
	public void insertDosen(String IDDosen, String namaDosen, String dept_no) {
		String sql = "Insert into Dosen (IDDosen,namaDosen,dept_no) "//
				+ " values (?,?,?) ";
		

		Object[] params = new Object[] { IDDosen, namaDosen, dept_no };
		this.getJdbcTemplate().update(sql, params);
	}

	@Override
	public int getMaxDeptId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Dosen findDosen(String IDDosen) {
	
		   String sql =DosenMapper.BASE_SQL //
	                + " where d.IDDosen = ?";

	        Object[] params = new Object[]{IDDosen};

	        DosenMapper mapper = new DosenMapper();

	        Dosen dos = this.getJdbcTemplate().queryForObject(sql, params, mapper);
	        return dos;
	}
	
	@Override
	public void updateDosen(String IDDosen, String namaDosen, String dept_no) {
	
		   String sql ="UPDATE dosen SET namaDosen = ?, dept_no=?  WHERE IDDosen = ?";

	        Object[] params = new Object[]{namaDosen,dept_no, IDDosen};


	       int rows = this.getJdbcTemplate().update(sql, params);
	       System.out.println(rows + " row(s) updated.");
	}

	@Override
	public List<Dosen> listDosen() {
		String sql = DosenMapper.BASE_SQL;

		Object[] params = new Object[] {};
		DosenMapper mapper = new DosenMapper();

		List<Dosen> list = this.getJdbcTemplate().query(sql, params, mapper);
		return list;
	}

	@Override
	public void deleteDosen(String IDDosen) {
		 Object[] params = { IDDosen };
		 // define SQL types of the arguments
	        //int[] types = {Types.BIGINT};
		 //String[] types = {Types.};
	String deleteSql = "DELETE FROM dosen WHERE IDDosen = ?";
		 int rows =  this.getJdbcTemplate().update(deleteSql, params);
		 System.out.println(rows + " row(s) deleted.");
	}

}
