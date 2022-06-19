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
@Table(name = "EmployeeMaster")
public class EmployeeMaster {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "EmployeeID", unique = true, nullable = false)
	private Integer employeeId;

	@Column(name = "EmployeeFirstName", length = 50)
	private String employeeFirstName;

	@Column(name = "EmployeeMiddleName", length = 50)
	private String employeeMiddleName;

	@Column(name = "EmployeeLastName", length = 50)
	private String employeeLastName;

	@Column(name = "EmployeeSuffix", length = 10)
	private String employeeSuffix;

	@Column(name = "EmployeeNickName", length = 50)
	private String employeeNickName;

	@Column(name = "EmloyeeDisplayName", length = 50)
	private String emloyeeDisplayName;

	@Column(name = "EmployeeDisplayInitials", length = 5)
	private String employeeDisplayInitials;

	@Column(name = "Gender", columnDefinition = "ENUM('Male','Female','Other')", length = 6)
	private String gender;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "BirthDate", length = 10)
	private Date birthDate;

	@Column(name = "HomeAddress_BldgUnit", length = 50)
	private String homeAddressBldgUnit;

	@Column(name = "HomeAddress_Street", length = 50)
	private String homeAddressStreet;

	@Column(name = "HomeAddress_Subdivision", length = 50)
	private String homeAddressSubdivision;

	@Column(name = "HomeAddress_Barangay", length = 50)
	private String homeAddressBarangay;

	@Column(name = "HomeAddress_City", length = 50)
	private String homeAddressCity;

	@Column(name = "HomeAddress_Province", length = 50)
	private String homeAddressProvince;

	@Column(name = "HomeAddress_PostalCode", length = 10)
	private String homeAddressPostalCode;

	@Column(name = "HomeAddress_CountryCode", length = 20)
	private String homeAddressCountryCode;

	@Column(name = "SameLocalAddress")
	private Boolean sameLocalAddress;

	@Column(name = "LocalAddress_BldgUnit", length = 50)
	private String localAddressBldgUnit;

	@Column(name = "LocalAddress_Street", length = 50)
	private String localAddressStreet;

	@Column(name = "LocalAddress_Subdivision", length = 50)
	private String localAddressSubdivision;

	@Column(name = "LocalAddress_Barangay", length = 50)
	private String localAddressBarangay;

	@Column(name = "LocalAddress_City", length = 50)
	private String localAddressCity;

	@Column(name = "LocalAddress_Province", length = 50)
	private String localAddressProvince;

	@Column(name = "LocalAddress_PostalCode", length = 10)
	private String localAddressPostalCode;

	@Column(name = "LocalAddress_CountryCode", length = 20)
	private String localAddressCountryCode;

	@Column(name = "Mobile_1_CountryCode", length = 20)
	private String mobile1CountryCode;

	@Column(name = "Mobile_1_AreaCode", length = 20)
	private String mobile1AreaCode;

	@Column(name = "Mobile_1_Number", length = 20)
	private String mobile1Number;

	@Column(name = "Mobile_2_CountryCode", length = 20)
	private String mobile2CountryCode;

	@Column(name = "Mobile_2_AreaCode", length = 20)
	private String mobile2AreaCode;

	@Column(name = "Mobile_2_Number", length = 20)
	private String mobile2Number;

	@Column(name = "Landline_CountryCode", length = 20)
	private String landlineCountryCode;

	@Column(name = "Landline_AreaCode", length = 20)
	private String landlineAreaCode;

	@Column(name = "Landline_Number", length = 20)
	private String landlineNumber;

	@Column(name = "PersonalEmailAddress", length = 50)
	private String personalEmailAddress;

	@Column(name = "Employee_IsEnabled")
	private Boolean employeeIsEnabled;

}
