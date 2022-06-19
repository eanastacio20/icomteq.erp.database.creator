package com.icomteq.erp.database.creator.persistence.company.configuration;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableJpaRepositories(basePackages = "com.icomteq.erp.database.creator.persistence.company", transactionManagerRef = "companyTransactionManager", entityManagerFactoryRef = "companyEntityManager")
@EnableTransactionManagement
@RequiredArgsConstructor
@DependsOn("dataSourceRouting")
public class ISIErpCompanyDataSource {

	@Autowired
	DataSourceRouting dataSourceRouting;

	@Bean(name = "companyEntityManager")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "validate");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		properties.put("spring.jpa.hibernate.naming.physical-strategy",
				"org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl");
		properties.put("spring.datasource.hikari.connection-timeout", 20000); //#maximum number of milliseconds that a client will wait for a connection
		properties.put("spring.datasource.hikari.minimum-idle", 100);//#minimum number of idle connections maintained by HikariCP in a connection pool
		properties.put("spring.datasource.hikari.maximum-pool-size", 500);//#maximum pool size
		properties.put("spring.datasource.hikari.idle-timeout", 10000);//#maximum idle time for connection
		properties.put("spring.datasource.hikari.max-lifetime", 1000);//# maximum lifetime in milliseconds of a connection in the pool after it is closed.
		//spring.datasource.hikari.auto-commit =true #default auto-commit behavior.
		return builder.dataSource(dataSourceRouting)
				.packages("com.icomteq.erp.database.creator.persistence.company").persistenceUnit("ErpCompany")
				.properties(properties).build();
	}

	@Bean(name = "companyTransactionManager")
	public JpaTransactionManager transactionManager(
			@Autowired @Qualifier("companyEntityManager") LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
		return new JpaTransactionManager(entityManagerFactoryBean.getObject());
	}
}
