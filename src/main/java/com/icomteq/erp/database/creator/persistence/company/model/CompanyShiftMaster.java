package com.icomteq.erp.database.creator.persistence.company.model;

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
@Table(name = "CompanyShiftMaster")
public class CompanyShiftMaster {

	@Id
	@Column(name = "ShiftID", unique = true, nullable = false, length = 10)
	private String shiftID;
	
	@Column(name = "ShiftDescription", length = 50)
	private String shiftDescription;
	
	@Column(name = "Hours_Sunday", precision = 12, scale = 0)
	private Float hoursSunday;
	
	@Column(name = "Hours_Monday", precision = 12, scale = 0)
	private Float hoursMonday;
	
	@Column(name = "Hours_Tuesday", precision = 12, scale = 0)
	private Float hoursTuesday;
	
	@Column(name = "Hours_Wednesday", precision = 12, scale = 0)
	private Float hoursWednesday;
	
	@Column(name = "Hours_Thursday", precision = 12, scale = 0)
	private Float hoursThursday;
	
	@Column(name = "Hours_Friday", precision = 12, scale = 0)
	private Float hoursFriday;
	
	@Column(name = "Hours_Saturday", precision = 12, scale = 0)
	private Float hoursSaturday;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "Lunch_Sunday", length = 16)
	private Date lunchSunday;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "Lunch_Monday", length = 16)
	private Date lunchMonday;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "Lunch_Tuesday", length = 16)
	private Date lunchTuesday;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "Lunch_Wednesday", length = 16)
	private Date lunchWednesday;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "Lunch_Thursday", length = 16)
	private Date lunchThursday;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "Lunch_Friday", length = 16)
	private Date lunchFriday;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "Lunch_Saturday", length = 16)
	private Date lunchSaturday;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "Start_Sunday", length = 16)
	private Date startSunday;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "Start_Monday", length = 16)
	private Date startMonday;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "Start_Tuesday", length = 16)
	private Date startTuesday;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "Start_Wednesday", length = 16)
	private Date startWednesday;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "Start_Thursday", length = 16)
	private Date startThursday;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "Start_Friday", length = 16)
	private Date startFriday;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "Start_Saturday", length = 16)
	private Date startSaturday;
	
	@Column(name = "FlexTime", precision = 12, scale = 0)
	private Float flexTime;
	
	@Column(name = "Allowance_Food", precision = 12, scale = 0)
	private Float allowanceFood;
	
	@Column(name = "Allowance_Transport", precision = 12, scale = 0)
	private Float allowanceTransport;
	
	@Column(name = "IsEnabled")
	private Boolean isEnabled;
	
	@Column(name = "LunchBreakTime", precision = 12, scale = 0)
	private Float lunchBreakTime;

	@Column(name = "PaidBreakTime", precision = 12, scale = 0)
	private Float paidBreakTime;

	@Column(name = "TotalWorkWeekHours", precision = 12, scale = 0)
	private Float totalWorkWeekHours;

}
