package com.icomteq.erp.database.creator.persistence.company.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CompanyAccessPermission")
public class CompanyAccessPermission {

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "profileId", column = @Column(name = "ProfileID", nullable = false)),
			@AttributeOverride(name = "moduleId", column = @Column(name = "ModuleID", nullable = false)),
			@AttributeOverride(name = "memberModuleId", column = @Column(name = "MemberModuleID", nullable = false)) })
	private CompanyAccessPermissionId id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ProfileID", nullable = false, insertable = false, updatable = false)
	private CompanyAccessProfile companyAccessProfile;

	@Column(name = "Access", nullable = false, length = 1)
	private char access;

}
