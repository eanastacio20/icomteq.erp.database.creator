package com.icomteq.erp.database.creator.persistence.master.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class MasterUserTrustedDeviceId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "UserID")
	private Integer userId;

	@Column(name = "DeviceID", length = 50)
	private String deviceId;

	@Column(name = "LastIPAddress", length = 120)
	private String lastIpaddress;

	@Column(name = "LastLocation", length = 120)
	private String lastLocation;

	@Column(name = "LastLoginTimeStamp", nullable = false, length = 26)
	private Date lastLoginTimeStamp;

}
