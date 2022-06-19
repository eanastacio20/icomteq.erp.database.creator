package com.icomteq.erp.database.creator.persistence.company.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import com.icomteq.erp.database.creator.configuration.ISIHrisApplicationProperties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class DataSourceRouting extends AbstractRoutingDataSource {

	private static Map<Object, Object> dataSourceMap = new HashMap<>();

	private ISIHrisApplicationProperties appProperties;

	private String selectedCompany;

	@Autowired
	public DataSourceRouting(ISIHrisApplicationProperties appProperties) {
		this.appProperties = appProperties;
		String dbName = appProperties.getCompanyDatasourceUrl()
				.substring(appProperties.getCompanyDatasourceUrl().lastIndexOf("/") + 1);
		setSelectedCompany(dbName);
		switchDb(dbName, appProperties.getCompanyDatasourceUrl(), appProperties.getCompanyDatasourceUsername(),
				appProperties.getCompanyDatasourcePassword(), appProperties.getCompanyDatasourceDriverClassName());
	}

	@Override
	protected Object determineCurrentLookupKey() {
		return null;
	}

	@Override
	protected DataSource determineTargetDataSource() {
		HikariDataSource ds = (HikariDataSource) dataSourceMap.get(getSelectedCompany());
		if (dataSourceMap.containsKey(getSelectedCompany())) {
			ds = (HikariDataSource) dataSourceMap.get(getSelectedCompany());
		}
		return ds;
	}

	public boolean switchDb(String companyId, String jdbcUrl, String username, String password,
			String driverClassName) {
		HikariDataSource ds = null;
		boolean success = false;
		if (dataSourceMap.containsKey(companyId)) {
			ds = (HikariDataSource) dataSourceMap.get(companyId);
		} else {
			ds = createCompanyDataSource(jdbcUrl, username, password, driverClassName);
			dataSourceMap.put(companyId, ds);
		}
		this.setTargetDataSources(dataSourceMap);
		this.setDefaultTargetDataSource(ds);
		System.out.println("SUCCESSFULLY SWITCH COMPANY TO " + jdbcUrl);
		success = true;
		return success;
	}

	private HikariDataSource createCompanyDataSource(String jdbcUrl, String username, String password,
			String driverClassName) {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(jdbcUrl);
		config.setUsername(username);
		config.setPassword(password);
		config.setDriverClassName(driverClassName);
		HikariDataSource ds = new HikariDataSource(config);
		return ds;
	}

}
