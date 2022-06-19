package com.icomteq.erp.database.creator.persistence.master.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MasterUser", uniqueConstraints = { @UniqueConstraint(columnNames = "ActiveDirUserName"),
		@UniqueConstraint(columnNames = "EmailAddress"), @UniqueConstraint(columnNames = "UserName") })
public class MasterUser {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "UserID", unique = true, nullable = false)
	private Integer userId;

	@Column(name = "ClientID")
	private Integer clientId;

	@Column(name = "UserName", unique = true, nullable = false, length = 100)
	private String userName;

	@Column(name = "UserFullName", nullable = false, length = 50)
	private String userFullName;

	@Column(name = "UserShortName", nullable = false, length = 50)
	private String userShortName;

	@Column(name = "UserPassword", nullable = false, length = 50)
	private String userPassword;

	@Column(name = "AllowPasswordChange", nullable = false)
	private byte allowPasswordChange;

	@Column(name = "PasswordExpires", nullable = false)
	private byte passwordExpires;

	@Temporal(TemporalType.DATE)
	@Column(name = "PasswordExpireDate", length = 10)
	private Date passwordExpireDate;

	@Column(name = "PasswordChangeToken", length = 50)
	private String passwordChangeToken;

	@Column(name = "PasswordChangeTokenURL", length = 120)
	private String passwordChangeTokenURL;

	@Column(name = "PasswordChangePIN", length = 20)
	private String passwordChangePin;

	@Temporal(TemporalType.DATE)
	@Column(name = "PasswordPINExpireDate", length = 10)
	private Date passwordPinexpireDate;

	@Temporal(TemporalType.TIME)
	@Column(name = "PasswordPINExpireTime", length = 16)
	private Date passwordPinexpireTime;

	@Column(name = "EmailAddress", unique = true, nullable = false, length = 120)
	private String emailAddress;

	@Column(name = "MobileCountryCode", length = 5)
	private String mobileCountryCode;

	@Column(name = "MobilePhoneNumber", length = 20)
	private String mobilePhoneNumber;

	@Column(name = "UserImagePath", length = 150)
	private String userImagePath;

	@Column(name = "CreatedByUserID", nullable = false)
	private int createdByUserId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreatedTimeStamp", nullable = false, length = 26)
	private Date createdTimeStamp;

	@Column(name = "LastEnabledByUserID")
	private Integer lastEnabledByUserId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LastEnabledTimeStamp", length = 26)
	private Date lastEnabledTimeStamp;

	@Column(name = "LastDisabledByUserID")
	private Integer lastDisabledByUserId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LastDisabledTimeStamp", length = 26)
	private Date lastDisabledTimeStamp;

	@Column(name = "LastSessionID")
	private Long lastSessionId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LastSessionTimeStamp", length = 26)
	private Date lastSessionTimeStamp;

	@Column(name = "ActiveDirUserName", unique = true, length = 50)
	private String activeDirUserName;

	@Column(name = "IMSAccessURL", length = 50)
	private String imsaccessUrl;

	@Column(name = "IMSAccessUserName", length = 120)
	private String imsaccessUserName;

	@Column(name = "IMSAccessPassword", length = 120)
	private String imsaccessPassword;

	@Column(name = "UserStatus", nullable = false)
	private byte userStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserTypeID", nullable = false)
	private MasterUserType masterUserType;
	
}
