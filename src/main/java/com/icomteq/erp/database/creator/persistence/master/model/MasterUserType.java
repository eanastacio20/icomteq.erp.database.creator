package com.icomteq.erp.database.creator.persistence.master.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MasterUserType", uniqueConstraints = @UniqueConstraint(columnNames = "UserTypeDescription"))
public class MasterUserType {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "UserTypeID", unique = true, nullable = false)
	private Short userTypeId;

	@Column(name = "UserTypeDescription", unique = true, nullable = false, length = 50)
	private String userTypeDescription;

	@Column(name = "Description", length = 100)
	private String description;

	@Column(name = "SuperUserAccess", nullable = false)
	private byte superUserAccess;

	@Column(name = "SupportAdminAccess", nullable = false)
	private byte supportAdminAccess;

	@Column(name = "ClientAdminAccess", nullable = false)
	private byte clientAdminAccess;

	@Column(name = "CompanyAdminAccess", nullable = false)
	private byte companyAdminAccess;

	@Column(name = "CompanyModuleAccess", nullable = false)
	private byte companyModuleAccess;

	@Column(name = "CompanyGuestAccess", nullable = false)
	private byte companyGuestAccess;

	@Column(name = "HasSameLevelAccess", nullable = false)
	private byte hasSameLevelAccess;

	@Column(name = "IsCompanyRole", nullable = false)
	private boolean isCompanyRole;

	@Column(name = "RecordType", columnDefinition = "ENUM(''ADD','EDIT','DELETE','OTHERS')", length = 8)
	private String recordType;

	@Column(name = "RecordActiveFlag", nullable = false)
	private byte recordActiveFlag;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userTypeId", nullable = false)
	private MasterUser masterUser;
	
}
