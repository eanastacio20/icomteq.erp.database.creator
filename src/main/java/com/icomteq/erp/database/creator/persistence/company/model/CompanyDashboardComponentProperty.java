package com.icomteq.erp.database.creator.persistence.company.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CompanyDashboardComponentProperty")
public class CompanyDashboardComponentProperty {

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "companyDashboardId", column = @Column(name = "CompanyDashboardID", nullable = false)),
			@AttributeOverride(name = "componentId", column = @Column(name = "ComponentID", nullable = false)),
			@AttributeOverride(name = "propertyId", column = @Column(name = "PropertyID", nullable = false)),
			@AttributeOverride(name = "instanceId", column = @Column(name = "InstanceID", nullable = false)),
			@AttributeOverride(name = "userId", column = @Column(name = "UserID", nullable = false)) })
	private CompanyDashboardComponentPropertyId id;

	@Column(name = "IsTemplate", nullable = false)
	private byte isTemplate;

	@Column(name = "Label", length = 100)
	private String label;

	@Column(name = "FieldName")
	private String fieldName;

	@Column(name = "PropertyField", columnDefinition = "text", length = 65535)
	private String propertyField;

	@Column(name = "PropertyAlias", length = 100)
	private String propertyAlias;

	@Column(name = "FormatSpec", length = 100)
	private String formatSpec;

}
