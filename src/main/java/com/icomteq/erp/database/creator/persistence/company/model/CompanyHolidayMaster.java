package com.icomteq.erp.database.creator.persistence.company.model;

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
@Table(name = "CompanyHolidayMaster")
public class CompanyHolidayMaster {

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "calendarYear", column = @Column(name = "CalendarYear", columnDefinition = "year", nullable = false, length = 4)),
			@AttributeOverride(name = "calendarDate", column = @Column(name = "CalendarDate", columnDefinition = "date", nullable = false, length = 10)) })
	private CompanyHolidayMasterId id;

	@Column(name = "EventName", length = 50)
	private String eventName;

	@Column(name = "RepeatFrequency", columnDefinition = "ENUM('Yearly')", length = 6)
	private String repeatFrequency;

	@Temporal(TemporalType.DATE)
	@Column(name = "RepeatStartYear", length = 4)
	private Date repeatStartYear;

	@Temporal(TemporalType.DATE)
	@Column(name = "RepeatEndYear", length = 4)
	private Date repeatEndYear;

	@Column(name = "HolidayType", columnDefinition = "ENUM('Regular','Special','Company','School')", length = 7)
	private String holidayType;

	@Column(name = "IsObserved", length = 1)
	private String isObserved;

}
