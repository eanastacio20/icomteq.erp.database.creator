package com.icomteq.erp.database.creator.persistence.company.model;

import java.io.Serializable;
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
@Table(name = "EmployeeTimeLogAudit")
public class EmployeeTimeLogAudit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "employeeId", column = @Column(name = "EmployeeID", nullable = false)),
			@AttributeOverride(name = "employeeDate", column = @Column(name = "EmployeeDate", nullable = false, length = 10)),
			@AttributeOverride(name = "employeeTime", column = @Column(name = "EmployeeTime", columnDefinition = "time", nullable = false, length = 16)),
			@AttributeOverride(name = "sequenceId", column = @Column(name = "SequenceID", nullable = false)) })
	private EmployeeTimeLogAuditId id;

	@Column(name = "ActionType", columnDefinition = "ENUM('Deleted','Changed','New')", length = 7)
	private String actionType;

	@Temporal(TemporalType.DATE)
	@Column(name = "FromDateIn", length = 10)
	private Date fromDateIn;

	@Temporal(TemporalType.TIME)
	@Column(name = "FromTimeIn", length = 16)
	private Date fromTimeIn;

	@Temporal(TemporalType.DATE)
	@Column(name = "FromDateOut", length = 10)
	private Date fromDateOut;

	@Temporal(TemporalType.TIME)
	@Column(name = "FromTimeOut", length = 16)
	private Date fromTimeOut;

	@Temporal(TemporalType.DATE)
	@Column(name = "ToDateIn", length = 10)
	private Date toDateIn;

	@Temporal(TemporalType.TIME)
	@Column(name = "ToTimeIn", length = 16)
	private Date toTimeIn;

	@Temporal(TemporalType.DATE)
	@Column(name = "ToDateOut", length = 10)
	private Date toDateOut;

	@Temporal(TemporalType.TIME)
	@Column(name = "ToTimeOut", length = 16)
	private Date toTimeOut;

	@Column(name = "UpdatedbyUserID")
	private Integer updatedbyUserId;

	@Column(name = "Reason", length = 100)
	private String reason;

}
