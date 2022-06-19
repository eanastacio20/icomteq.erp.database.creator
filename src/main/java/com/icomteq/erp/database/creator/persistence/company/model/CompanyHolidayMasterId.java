package com.icomteq.erp.database.creator.persistence.company.model;

import java.io.Serializable;
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
public class CompanyHolidayMasterId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "CalendarYear", nullable = false, length = 4)
	private Date calendarYear;
	
	@Column(name = "CalendarDate", nullable = false, length = 10)
	private Date calendarDate;
	
}
