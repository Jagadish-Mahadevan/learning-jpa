package jm.javademo.core.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ConditionalOnClass(DataSource.class)
@ConfigurationProperties(prefix="jpademo.datasource")
@EnableJpaRepositories(
		basePackages="jm.javademo.core.dao",
		entityManagerFactoryRef="entityManagerFactory",
		transactionManagerRef="transactionManager"
	)
public class EmployeeDatabaseConfig {
	
	@Bean
	@ConditionalOnProperty(name="jpademo.empDb.enabled", havingValue="true")
	@ConditionalOnMissingBean
	public DataSource dataSource() {	
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/employee?createDatabaseIfNotExist=true&&serverTimezone=UTC");
		dataSource.setUsername("Jagadish");
		dataSource.setPassword("Ireland1");
		return dataSource;
	}
	
	@Bean(name="entityManagerFactory")
	@ConditionalOnBean(name = "dataSource")
	@ConditionalOnMissingBean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setPackagesToScan("jm.javademo.core.entity");
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		return emf;
	}
	
    @Bean(name="transactionManager")
    @ConditionalOnMissingBean(type = "JpaTransactionManager")
    JpaTransactionManager transactionManager(final EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}