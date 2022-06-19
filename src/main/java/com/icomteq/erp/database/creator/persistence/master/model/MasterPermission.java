package com.icomteq.erp.database.creator.persistence.master.model;


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.icomteq.erp.database.creator.enums.PermissionAccess;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MasterPermission")
public class MasterPermission implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "userTypeId", column = @Column(name = "UserTypeID", nullable = false)),
			@AttributeOverride(name = "moduleId", column = @Column(name = "ModuleID", nullable = false)),
			@AttributeOverride(name = "memberModuleId", column = @Column(name = "MemberModuleID", nullable = false))})
	private MasterPermissionId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserTypeID", nullable = false, insertable = false, updatable = false)
	private MasterUserType masterUserType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ModuleID", nullable = false, insertable = false, updatable = false)
	private MasterModule masterModuleByModuleId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MemberModuleID", nullable = false, insertable = false, updatable = false)
	private MasterModule masterModuleByMemberModuleId;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "PermissionAccess", columnDefinition = "ENUM('CUSTOM','FULL','NONE','VIEW')", nullable = false, length = 6)
	private PermissionAccess permissionAccess;
	
}
