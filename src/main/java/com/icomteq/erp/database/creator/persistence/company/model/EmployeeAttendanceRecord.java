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
@Table(name = "EmployeeAttendanceRecord")
public class EmployeeAttendanceRecord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "employeeId", column = @Column(name = "EmployeeID", nullable = false)),
			@AttributeOverride(name = "employeeAttendanceDate", column = @Column(name = "EmployeeAttendanceDate", nullable = false, length = 10)) })
	private EmployeeAttendanceRecordId id;

	@Column(name = "EmployeeShiftCode", length = 5)
	private String employeeShiftCode;

	@Column(name = "EmployeeDayType")
	private Byte employeeDayType;

	@Column(name = "WorkdayHours", precision = 12, scale = 0)
	private Float workdayHours;

	@Temporal(TemporalType.TIME)
	@Column(name = "WorkdayStartTime", length = 16)
	private Date workdayStartTime;

	@Temporal(TemporalType.TIME)
	@Column(name = "WorkdayFlexTime", length = 16)
	private Date workdayFlexTime;

	@Temporal(TemporalType.TIME)
	@Column(name = "WorkdayLunch", length = 16)
	private Date workdayLunch;

	@Temporal(TemporalType.TIME)
	@Column(name = "WorkdayBreak", length = 16)
	private Date workdayBreak;

	@Temporal(TemporalType.DATE)
	@Column(name = "In_Date", length = 10)
	private Date inDate;

	@Temporal(TemporalType.TIME)
	@Column(name = "In_Time", length = 16)
	private Date inTime;

	@Temporal(TemporalType.DATE)
	@Column(name = "Out_Date", length = 10)
	private Date outDate;

	@Temporal(TemporalType.TIME)
	@Column(name = "Out_Time", length = 16)
	private Date outTime;

	@Column(name = "TimeSpent_Undertime", precision = 12, scale = 0)
	private Float timeSpentUndertime;

	@Column(name = "TimeSpent_Late", precision = 12, scale = 0)
	private Float timeSpentLate;

	@Column(name = "TimeSpent_Early", precision = 12, scale = 0)
	private Float timeSpentEarly;

	@Column(name = "TimeSpent_Lunch", precision = 12, scale = 0)
	private Float timeSpentLunch;

	@Column(name = "TimeSpent_Break", precision = 12, scale = 0)
	private Float timeSpentBreak;

	@Column(name = "TimeSpent_Overtime", precision = 12, scale = 0)
	private Float timeSpentOvertime;

	@Column(name = "HalfdayFlag")
	private Boolean halfdayFlag;

	@Column(name = "WorkdayLeaveFlag", length = 1)
	private String workdayLeaveFlag;

	@Column(name = "LeaveExemptRemarks", length = 100)
	private String leaveExemptRemarks;

	@Column(name = "LateFlag", length = 1)
	private String lateFlag;

	@Column(name = "LateRemarks", length = 100)
	private String lateRemarks;

	@Column(name = "LunchOverbreakFlag", length = 1)
	private String lunchOverbreakFlag;

	@Column(name = "LunchOverbreakRemarks", length = 100)
	private String lunchOverbreakRemarks;

	@Column(name = "WorkOverbreakFlag", length = 1)
	private String workOverbreakFlag;

	@Column(name = "WorkOverbreakRemarks", length = 100)
	private String workOverbreakRemarks;

	@Column(name = "OvertimeFlag", length = 1)
	private String overtimeFlag;

	@Column(name = "OvertimeRemarks", length = 100)
	private String overtimeRemarks;

	@Column(name = "UndertimeFlag", length = 1)
	private String undertimeFlag;

	@Column(name = "UndertimeRemarks", length = 100)
	private String undertimeRemarks;

	@Column(name = "AttendanceTime", precision = 12, scale = 0)
	private Float attendanceTime;

	@Column(name = "EmployeeTeamID")
	private Integer employeeTeamId;

	@Column(name = "EmployeeSupervisorID")
	private Integer employeeSupervisorId;

	@Column(name = "HasOverUnder")
	private Boolean hasOverUnder;

	@Column(name = "HasInfraction")
	private Boolean hasInfraction;

	@Column(name = "HasExempt")
	private Boolean hasExempt;

}
