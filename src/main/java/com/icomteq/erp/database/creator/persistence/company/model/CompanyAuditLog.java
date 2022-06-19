package com.icomteq.erp.database.creator.persistence.company.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "CompanyAuditLog")
public class CompanyAuditLog {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "AuditLogID", unique = true, nullable = false)
	private Long auditLogId;

	@Column(name = "SessionID")
	private Long sessionId;

	@Column(name = "InitiatedByUserID", nullable = false)
	private int initiatedByUserId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "InitiatedTimestamp", length = 26)
	private Date initiatedTimestamp;

	@Column(name = "ModuleID")
	private Short moduleId;

	@Column(name = "ModuleName")
	private String moduleName;

	@Column(name = "ActionID")
	private Short actionId;

	@Column(name = "ActionName")
	private String actionName;

	@Column(name = "ObjectID", nullable = false)
	private long objectId;

	@Column(name = "ObjectType", nullable = false)
	private byte objectType;

	@Column(name = "ObjectName")
	private String objectName;

	@Column(name = "ActionParticulars", columnDefinition = "longtext")
	private String actionParticulars;

	@Column(name = "TechnicalParticulars", columnDefinition = "longtext")
	private String technicalParticulars;

	@Column(name = "MetaHeader")
	private String metaHeader;

	@Column(name = "IPAddress", length = 15)
	private String ipaddress;

	@Column(name = "SourceFolderID")
	private Long sourceFolderId;

	@Column(name = "DestinationFolderID")
	private Long destinationFolderId;

}
