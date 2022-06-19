package com.icomteq.erp.database.creator.persistence.master.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MasterModule", uniqueConstraints = @UniqueConstraint(columnNames = "FullDisplayName"))
public class MasterModule implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ModuleID", unique = true, nullable = false)
	private Short moduleId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ParentModuleID")
	private MasterModule masterModule;

	@Column(name = "FullDisplayName", unique = true, length = 50)
	private String fullDisplayName;

	@Column(name = "ShortDisplayName", length = 50)
	private String shortDisplayName;

	@Column(name = "Description", columnDefinition = "text", length = 65535)
	private String description;

	@Column(name = "MenuLevel", nullable = false)
	private byte menuLevel;

	@Column(name = "ModuleMode", columnDefinition = "ENUM('MODULE','ACTION','PAGE')", length = 6)
	private String moduleMode;

	@Column(name = "URL", length = 120)
	private String url;

	@Column(name = "IconPath", length = 120)
	private String iconPath;

	@Column(name = "PermissionType", columnDefinition = "ENUM('COMPANY','SYSTEM')", length = 7)
	private String permissionType;

	@Column(name = "ModuleType", columnDefinition = "ENUM('COMPANY','SYSTEM')", length = 7)
	private String moduleType;

	@Column(name = "PermissionAccessOptions", length = 50)
	private String permissionAccessOptions;

	@Column(name = "RequiresSelected", columnDefinition = "ENUM('CLIENT','COMPANY')", length = 7)
	private String requiresSelected;

	@Column(name = "MethodCall", columnDefinition = "text", length = 65535)
	private String methodCall;

	@Column(name = "RerenderTarget", columnDefinition = "text", length = 65535)
	private String rerenderTarget;
	
	@Column(name = "UrlParam", columnDefinition = "text", length = 65535)
	private String urlParam;

	@Column(name = "ShowInNavigationMenu", nullable = false)
	private byte showInNavigationMenu;

	@Column(name = "ShowWhenDisabled", nullable = false)
	private boolean showWhenDisabled;

	@Column(name = "IsAuditable", nullable = false)
	private boolean isAuditable;

	@Column(name = "AllowAsHomePage", nullable = false)
	private byte allowAsHomePage;

	@Column(name = "TooltipText", columnDefinition = "text", length = 65535)
	private String tooltipText;

	@Column(name = "AlertText", columnDefinition = "text", length = 65535)
	private String alertText;
	
	@Column(name = "DialogText", columnDefinition = "text", length = 65535)
	private String dialogText;

	@Column(name = "SystemRequiredFlag", nullable = false)
	private byte systemRequiredFlag;

	@Column(name = "RecordActiveFlag", nullable = false)
	private byte recordActiveFlag;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "masterModuleByMemberModuleId")
	private Set<MasterClientPermission> masterClientPermissionsForMemberModuleId = new HashSet<MasterClientPermission>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "masterModuleByPermissionProxyModuleId")
	private Set<MasterModuleTree> masterModuleTreesForPermissionProxyModuleId = new HashSet<MasterModuleTree>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "masterModuleByMemberModuleId")
	private Set<MasterPermission> masterPermissionsForMemberModuleId = new HashSet<MasterPermission>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "masterModule")
	private Set<MasterModule> masterModules = new HashSet<MasterModule>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "masterModuleByModuleId")
	private Set<MasterPermission> masterPermissionsForModuleId = new HashSet<MasterPermission>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "masterModuleByMemberModuleId")
	private Set<MasterCompanyPermission> masterCompanyPermissionsForMemberModuleId = new HashSet<MasterCompanyPermission>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "masterModuleByModuleId")
	private Set<MasterClientPermission> masterClientPermissionsForModuleId = new HashSet<MasterClientPermission>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "masterModuleByModuleId")
	private Set<MasterCompanyPermission> masterCompanyPermissionsForModuleId = new HashSet<MasterCompanyPermission>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "masterModule")
	private Set<MasterDashboardComponentDetails> masterDashboardComponentDetailses = new HashSet<MasterDashboardComponentDetails>(0);

	@Transient
	private String displayNameOverride;

	@Transient
	private String orderSequence;

	@Transient
	private String iconPathOverride;

	@Transient
	private byte showInNavigationMenuOverride;
}
