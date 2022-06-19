package com.icomteq.erp.database.creator.persistence.company.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CompanyAccessProfile")
public class CompanyAccessProfile {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ProfileID", unique = true, nullable = false)
	private Short profileId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CreatedByUserID")
	private CompanyUser companyUser;

	@Column(name = "ProfileName", length = 50)
	private String profileName;

	@Column(name = "Description")
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreatedTimeStamp", nullable = false, length = 26)
	private Date createdTimeStamp;

	@Column(name = "Remarks", columnDefinition = "text", length = 65535)
	private String remarks;

	@Column(name = "Restricted", nullable = false)
	private boolean restricted;

	@Column(name = "CopyFromProfileId")
	private Short copyFromProfileId;
	
	@Column(name = "EmailAddress", length = 120)
	private String emailAddress;

	@Column(name = "MobileCountryCode", length = 5)
	private String mobileCountryCode;

	@Column(name = "MobileNumber", length = 15)
	private String mobileNumber;

	@Column(name = "IsCompanyRole")
	private Boolean isCompanyRole;

	@Column(name = "RefUserTypeID")
	private Short refUserTypeId;

	@Column(name = "HasAdminAccess")
	private Boolean hasAdminAccess;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "companyAccessProfile")
	private Set<CompanyAccessPermission> companyAccessPermissions = new HashSet<CompanyAccessPermission>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "companyAccessProfile")
	private Set<CompanyUser> companyUsers = new HashSet<CompanyUser>(0);

}
