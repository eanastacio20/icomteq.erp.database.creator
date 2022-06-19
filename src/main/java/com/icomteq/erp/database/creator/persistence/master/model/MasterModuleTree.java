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
@Table(name = "MasterModuleTree")
public class MasterModuleTree implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "moduleId", column = @Column(name = "ModuleID", nullable = false)),
			@AttributeOverride(name = "memberModuleId", column = @Column(name = "MemberModuleID", nullable = false)) })
	private MasterModuleTreeId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PermissionProxyModuleID")
	private MasterModule masterModuleByPermissionProxyModuleId;

	@Column(name = "DisplayNameOverride", columnDefinition = "text", length = 65535)
	private String displayNameOverride;

	@Column(name = "OrderSequence")
	private Short orderSequence;

	@Column(name = "URLOverride", length = 120)
	private String urloverride;

	@Column(name = "IconPathOverride", length = 120)
	private String iconPathOverride;
	
	@Column(name = "MethodCallOverride", columnDefinition = "text", length = 65535)
	private String methodCallOverride;

	@Column(name = "RerenderTargetOverride", columnDefinition = "text", length = 65535)
	private String rerenderTargetOverride;

	@Column(name = "ShowInNavigationMenuOverride", nullable = false)
	private byte showInNavigationMenuOverride;

	@Column(name = "InternalGroup", length = 1)
	private Character internalGroup;

	@Column(name = "CustomCss", length = 50)
	private String customCss;

}
