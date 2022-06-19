package com.icomteq.erp.database.creator.persistence.company.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CompanyDashboardComponentPropertyId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "CompanyDashboardID", nullable = false)
	private int companyDashboardId;
	
	@Column(name = "ComponentID", nullable = false)
	private int componentId;
	
	@Column(name = "PropertyID", nullable = false)
	private int propertyId;
	
	@Column(name = "InstanceID", nullable = false)
	private int instanceId;
	
	@Column(name = "UserID", nullable = false)
	private int userId;
	
}
