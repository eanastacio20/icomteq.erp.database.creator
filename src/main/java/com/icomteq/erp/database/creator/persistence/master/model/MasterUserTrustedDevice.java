package com.icomteq.erp.database.creator.persistence.master.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MasterUserTrustedDevice")
public class MasterUserTrustedDevice implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "userId", column = @Column(name = "UserID")),
			@AttributeOverride(name = "deviceId", column = @Column(name = "DeviceID", length = 50)),
			@AttributeOverride(name = "lastIpaddress", column = @Column(name = "LastIPAddress", length = 120)),
			@AttributeOverride(name = "lastLocation", column = @Column(name = "LastLocation", length = 120)),
			@AttributeOverride(name = "lastLoginTimeStamp", column = @Column(name = "LastLoginTimeStamp", nullable = false, length = 26))})
	private MasterUserTrustedDeviceId id;
	
}
