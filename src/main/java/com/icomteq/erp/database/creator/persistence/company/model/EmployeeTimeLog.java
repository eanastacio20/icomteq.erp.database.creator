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
@Table(name = "EmployeeTimeLog")
public class EmployeeTimeLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "employeeId", column = @Column(name = "EmployeeID", nullable = false)),
			@AttributeOverride(name = "employeeDateIn", column = @Column(name = "EmployeeDateIn", nullable = false, length = 10)),
			@AttributeOverride(name = "employeeTimeIn", column = @Column(name = "EmployeeTimeIn", columnDefinition = "time", nullable = false, length = 16)) })
	private EmployeeTimeLogId id;

	@Temporal(TemporalType.DATE)
	@Column(name = "EmployeeDateOut", length = 10)
	private Date employeeDateOut;

	@Temporal(TemporalType.TIME)
	@Column(name = "EmployeeTimeOut", length = 16)
	private Date employeeTimeOut;

	@Column(name = "EmployeeLocation", length = 100)
	private String employeeLocation;

	@Column(name = "HasUpdate")
	private Boolean hasUpdate;

	@Column(name = "IsProcessed")
	private Boolean isProcessed;

}
