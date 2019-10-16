package org.pallar.config;
 
import javax.sql.DataSource;
 


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("org.pallar.*")
 
@EnableTransactionManagement
 
// Load to Environment.
@PropertySources({ @PropertySource("classpath:resources/ds/datasource-cfg.properties") })
 
public class ApplicationContextConfig {
 
   // The Environment class serves as the property holder
   // and stores all the properties loaded by the @PropertySource
   @Autowired
   private Environment env;
 

	
   
	
   @Bean(name = "dataSource")
   public DataSource getDataSource() {
       DriverManagerDataSource dataSource = new DriverManagerDataSource();
 
       // See: datasouce-cfg.properties
       dataSource.setDriverClassName(env.getProperty("ds.database-driver"));
       dataSource.setUrl(env.getProperty("ds.url"));
       dataSource.setUsername(env.getProperty("ds.username"));
       dataSource.setPassword(env.getProperty("ds.password"));
 
       System.out.println("## getDataSource: " + dataSource);
 
       return dataSource;
   }
 
   @Bean(name = "transactionManager")
   public DataSourceTransactionManager getTransactionManager() {
       DataSourceTransactionManager txManager = new DataSourceTransactionManager();
 
       DataSource dataSource = this.getDataSource();
       txManager.setDataSource(dataSource);
 
       return txManager;
   }
 
}
