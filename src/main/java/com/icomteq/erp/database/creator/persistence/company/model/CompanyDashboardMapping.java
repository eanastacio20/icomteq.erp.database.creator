package com.icomteq.erp.database.creator.persistence.company.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CompanyDashboardMapping")
public class CompanyDashboardMapping {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "RecordID", unique = true, nullable = false)
	private Long recordId;
	
	@Column(name = "UserID")
	private Integer userId;
	
	@Column(name = "PlaceHolderID")
	private Integer placeHolderId;
	
	@Column(name = "CompanyDashboardID", nullable = false)
	private int companyDashboardId;
	
	@Column(name = "ComponentID")
	private Integer componentId;
	
	@Column(name = "InstanceID", nullable = false)
	private int instanceId;
	
}
