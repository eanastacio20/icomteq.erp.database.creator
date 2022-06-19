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
@Table(name = "MasterAppliance")
public class MasterAppliance implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ApplianceID", unique = true, nullable = false)
	private int applianceId;
	
	@Column(name = "DatabaseType", length = 30)
	private String databaseType;
	
	@Column(name = "HostName", length = 120)
	private String hostName;
	
	@Column(name = "HostPort", length = 10)
	private String hostPort;
	
	@Column(name = "IPAddress", length = 50)
	private String ipaddress;
	
	@Column(name = "ConnectionUserID", length = 20)
	private String connectionUserId;
	
	@Column(name = "ConnectionPassword", length = 20)
	private String connectionPassword;
	
	@Column(name = "DatabaseName", length = 30)
	private String databaseName;
	
	@Column(name = "Notes", columnDefinition = "TEXT", length = 65535)
	private String notes;
	
	@Column(name = "RecordActiveFlag", nullable = false)
	private byte recordActiveFlag;
	
}
