package com.icomteq.erp.database.creator.enums;

public enum FieldNameFilter {
	
	CLIENT_ID("clientId"),
	COMPANY_ID("companyId"),
	COMPANY_NAME("companyName"), 
	PRIMARY_COMPANY_ADMIN("primaryCompanyAdminUser"), 
	COMPANY_STATUS_FLAG("companyStatusFlag"),
	MODULE_ACCESS("moduleAccess");

	private String name;

	FieldNameFilter(String name) {
		this.name = name;
	}

	public String toString() {
		return this.name;
	}
	
}
