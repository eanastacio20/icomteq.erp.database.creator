package com.icomteq.erp.database.creator.persistence.master.model;


import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class MasterPermissionId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "UserTypeID", nullable = false)
	private short userTypeId;
	
	@Column(name = "ModuleID", nullable = false)
	private short moduleId;
	
	@Column(name = "MemberModuleID", nullable = false)
	private short memberModuleId;
	
}
