package com.icomteq.erp.database.creator.persistence.master.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "MasterSessionControl")
public class MasterSessionControl {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "SessionID", unique = true, nullable = false)
	private Long sessionId;
	
	@Column(name = "UserID", nullable = false)
	private int userId;
	
	@Column(name = "UserTypeID", nullable = false)
	private short userTypeId;
	
	@Column(name = "CompanyID")
	private Integer companyId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LoginTimeStamp", nullable = false, length = 26)
	private Date loginTimeStamp;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LogoutTimeStamp", length = 26)
	private Date logoutTimeStamp;
	
	@Column(name = "LastURLRequest", length = 120)
	private String lastUrlrequest;
	
	@Column(name = "ServerID")
	private String serverId;
	
	@Column(name = "MetaHeader")
	private String metaHeader;
	
	@Column(name = "Browser", length = 120)
	private String browser;
	
	@Column(name = "IPAddress", length = 50)
	private String ipaddress;
	
	@Column(name = "Location", length = 120)
	private String location;
	
	@Column(name = "ReturnToURL", length = 120)
	private String returnToUrl;
	
}
