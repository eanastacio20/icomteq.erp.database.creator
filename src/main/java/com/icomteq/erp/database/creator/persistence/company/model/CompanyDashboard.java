package com.icomteq.erp.database.creator.persistence.company.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CompanyDashboard")
public class CompanyDashboard {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CompanyDashboardID", unique = true, nullable = false)
	private Integer companyDashboardId;
	
	@Column(name = "DashboardID", nullable = false)
	private int dashboardId;
	
	@Column(name = "UserID", nullable = false)
	private int userId;
	
	@Column(name = "RecordActiveFlag")
	private Byte recordActiveFlag;
	
}
