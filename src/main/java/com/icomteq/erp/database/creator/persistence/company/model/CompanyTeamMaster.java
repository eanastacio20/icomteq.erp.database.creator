package com.icomteq.erp.database.creator.persistence.company.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CompanyTeamMaster")
public class CompanyTeamMaster {

	@Id
	@Column(name = "TeamID", unique = true, nullable = false, length = 10)
	private String teamId;
	
	@Column(name = "TeamName", length = 50)
	private String teamName;
	
	@Column(name = "DivisionCode", length = 10)
	private String divisionCode;
	
	@Column(name = "DepartmentCode", length = 10)
	private String departmentCode;
	
	@Column(name = "ReportTo_TeamID", length = 10)
	private String reportToTeamId;
	
	@Column(name = "TeamLead_EmployeeID")
	private Integer teamLeadEmployeeId;
	
}
