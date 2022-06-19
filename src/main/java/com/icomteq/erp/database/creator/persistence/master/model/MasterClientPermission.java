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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MasterClientPermission")
public class MasterClientPermission implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "clientId", column = @Column(name = "ClientID", nullable = false)),
			@AttributeOverride(name = "moduleId", column = @Column(name = "ModuleID", nullable = false)),
			@AttributeOverride(name = "memberModuleId", column = @Column(name = "MemberModuleID", nullable = false)),
			@AttributeOverride(name = "permissionAccess", column = @Column(name = "PermissionAccess", nullable = false, length = 6)),
			@AttributeOverride(name = "enabledFlag", column = @Column(name = "EnabledFlag", nullable = false))})
	private MasterClientPermissionId id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ClientID", nullable = false, insertable = false, updatable = false)
	private MasterClient masterClient;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ModuleID", nullable = false, insertable = false, updatable = false)
	private MasterModule masterModuleByModuleId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MemberModuleID", nullable = false, insertable = false, updatable = false)
	private MasterModule masterModuleByMemberModuleId;

}
