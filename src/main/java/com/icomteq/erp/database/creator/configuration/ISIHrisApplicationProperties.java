package com.icomteq.erp.database.creator.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;
import lombok.Setter;

@Configuration
@PropertySource("classpath:application.properties")
@Getter
@Setter
public class ISIHrisApplicationProperties {
	
	@Value("${file.system.os}")
	private String fileSystemOS;
	
	@Value("${erp.database.creator.script.windows}")
	private String databaseCreatorScriptWindows;
	
	@Value("${erp.database.creator.script.linux}")
	private String databaseCreatorScriptLinux;
	
	@Value("${spring.master.datasource.url}")
	private String masterDatasourceUrl;
	
	@Value("${spring.master.datasource.username}")
	private String masterDatasourceUsername;
	
	@Value("${spring.master.datasource.password}")
	private String masterDatasourcePassword;
	
	@Value("${spring.master.datasource.driver-class-name}")
	private String masterDatasourceDriverClassName;
	
	@Value("${spring.company.datasource.url}")
	private String companyDatasourceUrl;
	
	@Value("${spring.company.datasource.username}")
	private String companyDatasourceUsername;
	
	@Value("${spring.company.datasource.password}")
	private String companyDatasourcePassword;
	
	@Value("${spring.company.datasource.driver-class-name}")
	private String companyDatasourceDriverClassName;
	
	
}
