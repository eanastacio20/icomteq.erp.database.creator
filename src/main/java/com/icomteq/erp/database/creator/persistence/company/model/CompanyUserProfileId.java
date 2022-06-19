package com.icomteq.erp.database.creator.persistence.company.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CompanyUserProfileId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "UserID", nullable = false)
	private int userId;
	
	@Column(name = "ProfileID", nullable = false)
	private short profileId;

}
