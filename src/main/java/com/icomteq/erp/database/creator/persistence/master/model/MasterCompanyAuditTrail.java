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
@Table(name = "MasterCompanyAuditTrail")
public class MasterCompanyAuditTrail {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "RecordID", unique = true, nullable = false)
	private Long recordId;

	@Column(name = "CompanyID", nullable = false)
	private int companyId;

	@Column(name = "ActionType", columnDefinition = "ENUM('ADD','EDIT')", length = 4)
	private String actionType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LastModifiedTimeStamp", nullable = false, length = 26)
	private Date lastModifiedTimeStamp;

	@Column(name = "LastModifiedByUserID", nullable = false)
	private int lastModifiedByUserId;

	@Column(name = "Remarks", columnDefinition = "text", length = 65535)
	private String remarks;

}
