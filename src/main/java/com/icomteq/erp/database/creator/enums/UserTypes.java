package com.icomteq.erp.database.creator.enums;

import lombok.Getter;

@Getter
public enum UserTypes {
	
	SuperUser((short)1),
	SupportAdmin((short)2),
	ClientAdmin((short)3),
	CompanyAdmin((short)4),
	CompanyUser((short)5),
	CompanyGuest((short)6);
	
	UserTypes(short userType){
		this.userType = userType;
	}
	
	private short userType;
	
}
