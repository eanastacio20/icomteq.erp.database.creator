package com.icomteq.erp.database.creator.persistence.master.model;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "MasterUserCompany")
public class MasterUserCompany {

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "userId", column = @Column(name = "UserID", nullable = false)),
			@AttributeOverride(name = "companyId", column = @Column(name = "CompanyID", nullable = false))})
	private MasterUserCompanyId id;
	
	@Column(name = "EnabledByUserID")
	private Integer enabledByUserId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EnabledTimeStamp", length = 26)
	private Date enabledTimeStamp;
	
	@Column(name = "DisabledByUserID")
	private Integer disabledByUserId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DisabledTimeStamp", length = 26)
	private Date disabledTimeStamp;
	
	@Column(name = "RecordActiveFlag", nullable = false)
	private byte recordActiveFlag;
	
}
