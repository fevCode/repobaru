package org.pallar.dao;

import java.util.List;

import javax.sql.DataSource;

import org.pallar.mapper.LoginMapper;
import org.pallar.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class LoginDAO extends JdbcDaoSupport implements LoginDAOImplement {

   
    @Autowired
    public LoginDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

   

    @Override
    public List<Login> listLogin() {
        String sql = LoginMapper.BASE_SQL;

        Object[] params = new Object[]{};
        LoginMapper mapper = new LoginMapper();

        List<Login> list = this.getJdbcTemplate().query(sql, params, mapper);
        return list;
    }

   
  
    
    
    

}
