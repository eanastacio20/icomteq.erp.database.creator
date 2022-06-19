package com.icomteq.erp.database.creator.persistence.company.model;

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
public class EmployeeTimeLogAuditId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "EmployeeID", nullable = false)
	private int employeeId;

	@Column(name = "EmployeeDate", nullable = false, length = 10)
	private Date employeeDate;

	@Column(name = "EmployeeTime", nullable = false, length = 16)
	private Date employeeTime;

	@Column(name = "SequenceID", nullable = false)
	private byte sequenceId;

}
