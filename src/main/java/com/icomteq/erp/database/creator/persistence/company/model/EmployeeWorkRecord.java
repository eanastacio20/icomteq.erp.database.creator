package com.icomteq.erp.database.creator.persistence.company.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "EmployeeWorkRecord")
public class EmployeeWorkRecord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "EmployeeID", unique = true, nullable = false)
	private int employeeId;

	@Column(name = "EmployeeTeamCode", length = 10)
	private String employeeTeamCode;

	@Column(name = "EmployeePosition", length = 10)
	private String employeePosition;

	@Column(name = "EmployeeDesignation", length = 10)
	private String employeeDesignation;

	@Column(name = "EmployeeSalaryGrade", length = 10)
	private String employeeSalaryGrade;

	@Column(name = "EmployeeOfficialTitle", length = 50)
	private String employeeOfficialTitle;

	@Column(name = "EmployeeBiometricCode", length = 10)
	private String employeeBiometricCode;

	@Column(name = "WorkExtensionNo", length = 10)
	private String workExtensionNo;

	@Column(name = "WorkEmailAddress", length = 50)
	private String workEmailAddress;

	@Temporal(TemporalType.DATE)
	@Column(name = "HireDate", length = 10)
	private Date hireDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "PositionStartDate", length = 10)
	private Date positionStartDate;

	@Column(name = "EmploymentStatus")
	private Boolean employmentStatus;

	@Temporal(TemporalType.DATE)
	@Column(name = "ContractEndDate", length = 10)
	private Date contractEndDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "TerminationDate", length = 10)
	private Date terminationDate;

	@Column(name = "TerminationReason", length = 100)
	private String terminationReason;

	@Column(name = "PayCode")
	private Byte payCode;

	@Column(name = "PayType", columnDefinition = "ENUM('Hourly','Daily','Weekly','Monthly')", length = 7)
	private String payType;

	@Column(name = "PayFrequency", columnDefinition = "ENUM('Weekly','BiWeekly','SemiWeekly','Monthly')", length = 10)
	private String payFrequency;

	@Column(name = "PayMode", columnDefinition = "ENUM('Cash','Check','Deposit')", length = 7)
	private String payMode;

	@Column(name = "PayRate_Base", precision = 12, scale = 0)
	private Float payRateBase;

	@Column(name = "PayRate_LeadAllowance", precision = 12, scale = 0)
	private Float payRateLeadAllowance;

	@Column(name = "PayRate_Extra_Meals", precision = 12, scale = 0)
	private Float payRateExtraMeals;

	@Column(name = "PayRate_Extra_Transport", precision = 12, scale = 0)
	private Float payRateExtraTransport;

	@Column(name = "PayRate_Extra_Lodging", precision = 12, scale = 0)
	private Float payRateExtraLodging;

	@Column(name = "OTGrade")
	private Boolean otgrade;

	@Column(name = "Benefit_CompTime")
	private Boolean benefitCompTime;

	@Column(name = "Benefit_13thMonth")
	private Boolean benefit13thMonth;

	@Column(name = "VacationTimeBenefit", precision = 12, scale = 0)
	private Float vacationTimeBenefit;

	@Column(name = "SickTimeBenefit", precision = 12, scale = 0)
	private Float sickTimeBenefit;

	@Column(name = "CompTimeAllowance", precision = 12, scale = 0)
	private Float compTimeAllowance;

}
