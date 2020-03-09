package net.riking.transaction.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @Description
 * @Author kongLiuYi
 * @Date 2020/3/5 0005 11:43
 */
@Configuration
@ComponentScan("net.riking.transaction")
@EnableTransactionManagement
@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true, encoding = "UTF-8")
public class AppConfig {

	@Value("${spring.jdbc.url}")
	private String url;

	@Value("${spring.jdbc.username}")
	private String username;

	@Value("${spring.jdbc.password}")
	private String password;

	@Value("${spring.jdbc.driver-class-name}")
	private String driverClassName;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setDriverClassName(driverClassName);
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}


	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource) {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource);
		return transactionManager;
	}


}
