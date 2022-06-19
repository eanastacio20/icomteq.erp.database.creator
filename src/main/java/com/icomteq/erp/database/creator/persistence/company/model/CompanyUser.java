package com.icomteq.erp.database.creator.persistence.company.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CompanyUser", uniqueConstraints = { @UniqueConstraint(columnNames = { "UserID", "ClientID" }),
		@UniqueConstraint(columnNames = { "UserID", "UserType" }),
		@UniqueConstraint(columnNames = { "UserID", "GroupID" }),
		@UniqueConstraint(columnNames = { "UserID", "CompanyProfileID" }) })
public class CompanyUser {

	@Id
	@Column(name = "UserID", unique = true, nullable = false)
	private int userId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CompanyProfileID", nullable = false)
	private CompanyAccessProfile companyAccessProfile;

	@Column(name = "UserName", nullable = false, length = 100)
	private String userName;

	@Column(name = "UserFullName", nullable = false, length = 50)
	private String userFullName;

	@Column(name = "UserType", nullable = false)
	private short userType;

	@Column(name = "GroupID")
	private Integer groupId;

	@Column(name = "ClientID")
	private Integer clientId;

	@Column(name = "EmailAddress", nullable = false, length = 120)
	private String emailAddress;

	@Column(name = "UserStatus")
	private Byte userStatus;

	@Column(name = "CompanyUserStatus", nullable = false)
	private byte companyUserStatus;

	@Column(name = "LastSessionID")
	private Long lastSessionId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LastSessionLoginTimeStamp", length = 26)
	private Date lastSessionLoginTimeStamp;

	@Column(name = "UserObjectID", nullable = false)
	private long userObjectId;

	@Column(name = "UserObjectType")
	private Byte userObjectType;

	@Column(name = "RecordActiveFlag", nullable = false)
	private byte recordActiveFlag;

	@Column(name = "CompanyProfileAssignedByUserID")
	private Integer companyProfileAssignedByUserId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CompanyProfileAssignedTimeStamp", length = 26)
	private Date companyProfileAssignedTimeStamp;

	@Column(name = "MobileNumber", length = 20)
	private String mobileNumber;

	@Column(name = "MobileCountryCode", length = 5)
	private String mobileCountryCode;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "companyUser")
	private Set<CompanyAccessProfile> companyAccessProfiles = new HashSet<CompanyAccessProfile>(0);

}
