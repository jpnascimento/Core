package br.com.fisiofit.vendas.spring.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "br.com.fisiofit.vendas.spring.config" })
@PropertySource("classpath:database.properties")
public class DatabaseConnection {

	/**
	 * Mantém valores de configuração
	 */
	@Autowired
	private Environment environment;

	/**
	 * Configura data source
	 * 
	 * @return
	 */
	@Bean
	public DataSource getDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("database.driver"));
		dataSource.setUrl(environment.getRequiredProperty("database.url"));
		dataSource.setUsername(environment.getRequiredProperty("database.username"));
		dataSource.setPassword(environment.getRequiredProperty("database.password"));

		return dataSource;
	}

	/**
	 * Recupera o gerenciador de transações
	 * 
	 * @return
	 */
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}

	/**
	 * Hibernate template
	 * 
	 * @return
	 */
	@Bean
	@Autowired
	public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory) {
		return new HibernateTemplate(sessionFactory);
	}

	/**
	 * Cria uma fábrica de sessões
	 * 
	 * @return
	 * @throws IOException
	 */
	@Bean
	public SessionFactory getSessionFactory() {

		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(getDataSource());
		factoryBean.setHibernateProperties(getHibernateProperties());
		factoryBean.setPackagesToScan(new String[] { "br.com.fisiofit.vendas.spring.entity" });

		return factoryBean.getObject();
	}

	/**
	 * Propriedades da conexão do banco de dados
	 * 
	 * @return
	 */
	private Properties getHibernateProperties() {

		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		properties.put("hibernate.c3p0.min_size", environment.getProperty("hibernate.c3p0.min_size"));
		properties.put("hibernate.c3p0.max_size", environment.getProperty("hibernate.c3p0.max_size"));
		properties.put("hibernate.c3p0.timeout", environment.getProperty("hibernate.c3p0.timeout"));
		properties.put("hibernate.c3p0.max_statements", environment.getProperty("hibernate.c3p0.max_statements"));
		properties.put("hibernate.c3p0.idle_test_period", environment.getProperty("hibernate.c3p0.idle_test_period"));

		return properties;
	}
}
