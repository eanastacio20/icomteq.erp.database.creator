package com.icomteq.erp.database.creator.persistence.master.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MasterMountDetails", uniqueConstraints = @UniqueConstraint(columnNames = { "CompanyID",
		"ShareFolderName" }))
public class MasterMountDetails {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MountID", unique = true, nullable = false)
	private Integer mountId;

	@Column(name = "CompanyID", nullable = false)
	private int companyId;

	@Column(name = "IPAddress", nullable = false, length = 50)
	private String ipaddress;

	@Column(name = "ShareName", nullable = false, length = 50)
	private String shareName;

	@Column(name = "ShareFolderName", nullable = false, length = 50)
	private String shareFolderName;

	@Column(name = "ShareType", columnDefinition = "ENUM('cifs (Windows Share)','nfs')", nullable = false, length = 20)
	private String shareType;

	@Column(name = "Username", length = 50)
	private String username;

	@Column(name = "Password", length = 50)
	private String password;

	@Column(name = "Domain", length = 50)
	private String domain;

	@Column(name = "MountedFlag", nullable = false)
	private boolean mountedFlag;

}
