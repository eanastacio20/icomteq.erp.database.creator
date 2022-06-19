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
@Table(name = "CompanyControl")
public class CompanyControl {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ControlKey", unique = true, nullable = false)
	private Integer controlKey;

	@Column(name = "CompanyName", nullable = false, length = 120)
	private String companyName;

	@Column(name = "Company_BldgUnit", length = 100)
	private String companyBldgUnit;

	@Column(name = "Company_Street", length = 100)
	private String companyStreet;

	@Column(name = "Company_Subdivision", length = 100)
	private String companySubdivision;

	@Column(name = "Company_Barangay", length = 100)
	private String companyBarangay;

	@Column(name = "Company_City", length = 100)
	private String companyCity;

	@Column(name = "Company_Province", length = 100)
	private String companyProvince;

	@Column(name = "Company_PostalCode", length = 100)
	private String companyPostalCode;

	@Column(name = "CompanyCountryCode", length = 100)
	private String companyCountryCode;

	@Column(name = "CompanyPhoneAreaCode", length = 100)
	private String companyPhoneAreaCode;

	@Column(name = "CompanyPhoneNumber", length = 100)
	private String companyPhoneNumber;

	@Column(name = "CompanyEmailAddress", length = 100)
	private String companyEmailAddress;

	@Column(name = "CompanyContact", length = 100)
	private String companyContact;

	@Column(name = "CreatedByUserID", nullable = false)
	private int createdByUserId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreatedTimeStamp", nullable = false, length = 26)
	private Date createdTimeStamp;

	@Column(name = "LastModifiedByUserID", nullable = false)
	private int lastModifiedByUserId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LastModifiedTimeStamp", length = 26)
	private Date lastModifiedTimeStamp;

	@Column(name = "EmployeeIDMask", length = 100)
	private String employeeIdmask;

	@Column(name = "SalaryGradeFlag", nullable = false)
	private boolean salaryGradeFlag;

	@Column(name = "GradeLevelCount", nullable = false)
	private boolean gradeLevelCount;

	@Column(name = "GradeStepCount", nullable = false)
	private boolean gradeStepCount;

	@Column(name = "WeightUM", columnDefinition = "ENUM('LBS','KILOS')", nullable = false, length = 5)
	private String weightUm;

	@Column(name = "HeightUM", columnDefinition = "ENUM('INCHES','METERS')", nullable = false, length = 6)
	private String heightUm;

	@Column(name = "RecordActiveFlag", nullable = false)
	private byte recordActiveFlag;

}
