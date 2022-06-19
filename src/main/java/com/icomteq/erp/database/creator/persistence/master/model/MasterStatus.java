package com.icomteq.erp.database.creator.persistence.master.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MasterStatus", uniqueConstraints = @UniqueConstraint(columnNames = "StatusDescription"))
public class MasterStatus {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "StatusID", unique = true, nullable = false)
	private Byte statusId;
	
	@Column(name = "StatusDescription", unique = true, nullable = false, length = 20)
	private String statusDescription;
	
	@Column(name = "ReadAccess")
	private Boolean readAccess;
	
	@Column(name = "WriteAccess")
	private Boolean writeAccess;
	
	@Column(name = "RecordActiveFlag")
	private Boolean recordActiveFlag;
	
}
