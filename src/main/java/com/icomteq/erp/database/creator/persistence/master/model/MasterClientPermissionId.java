package com.icomteq.erp.database.creator.persistence.master.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class MasterClientPermissionId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "ClientID", nullable = false)
	private int clientId;

	@Column(name = "ModuleID", nullable = false)
	private short moduleId;

	@Column(name = "MemberModuleID", nullable = false)
	private short memberModuleId;

	@Column(name = "PermissionAccess", length = 1)
	private Character permissionAccess;

	@Column(name = "EnabledFlag", nullable = false)
	private byte enabledFlag;

}
