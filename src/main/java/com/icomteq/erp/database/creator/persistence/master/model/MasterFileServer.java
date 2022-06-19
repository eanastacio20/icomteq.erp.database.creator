package com.icomteq.erp.database.creator.persistence.master.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MasterFileServer")
public class MasterFileServer {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "FileServerID", unique = true, nullable = false)
	private Integer fileServerId;

	@Column(name = "HostName", nullable = false, length = 120)
	private String hostName;

	@Column(name = "IPAddress", nullable = false, length = 50)
	private String ipaddress;

	@Column(name = "ConnectionUserID", nullable = false, length = 20)
	private String connectionUserId;

	@Column(name = "ConnectionPassword", nullable = false, length = 20)
	private String connectionPassword;

	@Column(name = "ServerName", nullable = false, length = 30)
	private String serverName;

	@Column(name = "Notes", columnDefinition = "text", length = 65535)
	private String notes;

	@Column(name = "RecordActiveFlag", nullable = false)
	private byte recordActiveFlag;

}
