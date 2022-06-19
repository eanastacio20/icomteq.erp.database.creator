package com.icomteq.erp.database.creator.persistence.company.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CompanyReferenceMaster")
public class CompanyReferenceMaster {

	@Id
	@Column(name = "RefTypeID", unique = true, nullable = false, length = 20)
	private String refTypeId;
	
	@Column(name = "ReferenceCode", nullable = false, length = 20)
	private String referenceCode;
	
	@Column(name = "ReferenceDescription", length = 50)
	private String referenceDescription;
	
	@Column(name = "StatusFlag")
	private Boolean statusFlag;


}
