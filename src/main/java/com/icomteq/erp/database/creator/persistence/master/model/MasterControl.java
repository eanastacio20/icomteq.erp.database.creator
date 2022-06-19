package com.icomteq.erp.database.creator.persistence.master.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MasterControl")
public class MasterControl {

	@Id
	@Column(name = "HostID", unique = true, nullable = false)
	private int hostId;
	
	@Column(name = "HostName", length = 120)
	private String hostName;
	
	@Column(name = "HostURL", length = 120)
	private String hostUrl;
	
	@Column(name = "HostIPAddress", length = 50)
	private String hostIpaddress;
	
	@Column(name = "HostServerID", length = 50)
	private String hostServerId;
	
	@Column(name = "LicenseType", length = 20)
	private String licenseType;
	
	@Column(name = "LicenseNumber", length = 50)
	private String licenseNumber;
	
	@Column(name = "UserLicenseURL", length = 120)
	private String userLicenseUrl;
	
	@Column(name = "IsServiceProvider")
	private Boolean isServiceProvider;
	
	@Column(name = "BillingServiceURL", length = 120)
	private String billingServiceUrl;
	
	@Column(name = "PrimarySuperUserID")
	private Integer primarySuperUserId;
	
	@Column(name = "LogoImageURL", length = 120)
	private String logoImageUrl;
	
	@Column(name = "SplashImageURL", length = 120)
	private String splashImageUrl;
	
	@Column(name = "CSSURL")
	private byte[] cssurl;
	
	@Column(name = "LoginAuthenticationCallURL", length = 120)
	private String loginAuthenticationCallUrl;
	
	@Column(name = "ThemeName", length = 20)
	private String themeName;
	
	@Column(name = "HostSupportEmail", length = 120)
	private String hostSupportEmail;
	
	@Column(name = "HostSupportCountryCode")
	private Integer hostSupportCountryCode;
	
	@Column(name = "HostSupportPhoneNo", length = 20)
	private String hostSupportPhoneNo;
	
	@Column(name = "CurrentSoftwareVersion", length = 50)
	private String currentSoftwareVersion;
	
	@Column(name = "CopyrightYear", length = 20)
	private String copyrightYear;
	
	@Column(name = "ActiveDirectoryFlag", nullable = false)
	private byte activeDirectoryFlag;
	
}
