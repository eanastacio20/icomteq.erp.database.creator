package com.icomteq.erp.database.creator.persistence.master.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
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
@Table(name = "MasterClient")
public class MasterClient {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ClientID", unique = true, nullable = false)
	private Integer clientId;
	
	@Column(name = "ClientName", nullable = false, length = 50)
	private String clientName;
	
	@Column(name = "ClientURL", length = 50)
	private String clientUrl;
	
	@Column(name = "ClientIPAddress", length = 50)
	private String clientIpaddress;
	
	@Column(name = "Notes", length = 500)
	private String notes;
	
	@Column(name = "PrimaryClientAdminUserID")
	private Integer primaryClientAdminUserId;
	
	@Column(name = "IsServiceProvider", nullable = false)
	private byte isServiceProvider;
	
	@Column(name = "BillingServiceURL", length = 120)
	private String billingServiceUrl;
	
	@Column(name = "ClientLogoImageURL", length = 120)
	private String clientLogoImageUrl;
	
	@Column(name = "ClientSplashImageURL", length = 120)
	private String clientSplashImageUrl;
	
	@Column(name = "ClientCSSURL", length = 120)
	private String clientCssurl;
	
	@Column(name = "ClientThemeName", length = 50)
	private String clientThemeName;
	
	@Column(name = "ClientEmail", length = 50)
	private String clientEmail;
	
	@Column(name = "ClientCountryCode", length = 5)
	private String clientCountryCode;
	
	@Column(name = "ClientPhoneNo", length = 20)
	private String clientPhoneNo;
	
	@Column(name = "CreatedByUserID", nullable = false)
	private int createdByUserId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreatedTimeStamp", length = 26)
	private Date createdTimeStamp;
	
	@Column(name = "DisabledByUserID", nullable = false)
	private int disabledByUserId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DisabledTimeStamp", length = 26)
	private Date disabledTimeStamp;
	
	@Column(name = "ClientStatusFlag", nullable = false)
	private byte clientStatusFlag;

}
