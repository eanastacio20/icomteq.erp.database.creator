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
@Table(name = "CompanyUserProfile")
public class CompanyUserProfile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "userId", column = @Column(name = "UserID", nullable = false)),
			@AttributeOverride(name = "profileId", column = @Column(name = "ProfileID", nullable = false)) })
	private CompanyUserProfileId id;

	@Column(name = "UserProfileStatus")
	private Byte userProfileStatus;

	@Column(name = "UserProfileType")
	private Byte userProfileType;

	@Column(name = "CreatedByUserID")
	private Integer createdByUserId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreatedTimeStamp", nullable = false, length = 26)
	private Date createdTimeStamp;

}
