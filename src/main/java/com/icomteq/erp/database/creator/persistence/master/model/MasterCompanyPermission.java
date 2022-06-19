package com.icomteq.erp.database.creator.persistence.master.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MasterCompanyPermission")
public class MasterCompanyPermission {

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "companyId", column = @Column(name = "CompanyID", nullable = false)),
			@AttributeOverride(name = "moduleId", column = @Column(name = "ModuleID", nullable = false)),
			@AttributeOverride(name = "memberModuleId", column = @Column(name = "MemberModuleID", nullable = false))})
	private MasterCompanyPermissionId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CompanyID", nullable = false, insertable = false, updatable = false)
	private MasterCompany masterCompany;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ModuleID", nullable = false, insertable = false, updatable = false)
	private MasterModule masterModuleByModuleId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MemberModuleID", nullable = false, insertable = false, updatable = false)
	private MasterModule masterModuleByMemberModuleId;
	
	@Column(name = "PermissionAccess", columnDefinition = "ENUM('CUSTOM','FULL','NONE','VIEW')", nullable = false, length = 6)
	private String permissionAccess;
	
	@Column(name = "EnabledFlag")
	private Byte enabledFlag;
	
}
