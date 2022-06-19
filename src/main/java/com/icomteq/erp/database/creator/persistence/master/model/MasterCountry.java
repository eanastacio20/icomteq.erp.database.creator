package com.icomteq.erp.database.creator.persistence.master.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MasterCountry", uniqueConstraints = @UniqueConstraint(columnNames = "CountryName"))
public class MasterCountry {

	@Id
	@Column(name = "CountryCode", unique = true, nullable = false, length = 20)
	private String countryCode;

	@Column(name = "CountryName", unique = true, nullable = false, length = 50)
	private String countryName;

	@Column(name = "CountryAbbreviation", length = 20)
	private String countryAbbreviation;

	@Column(name = "DefaultTimeZone", length = 20)
	private String defaultTimeZone;

	@Column(name = "PhoneFormat", length = 20)
	private String phoneFormat;

	@Column(name = "DateFormat", length = 20)
	private String dateFormat;

	@Column(name = "TimeFormat", nullable = false)
	private boolean timeFormat;

	@Column(name = "ZipCodeFormat", length = 20)
	private String zipCodeFormat;

	@Column(name = "Currency", length = 20)
	private String currency;

	@Column(name = "ExchangeRate", nullable = false, precision = 12, scale = 0)
	private float exchangeRate;

	@Column(name = "LabelTownship")
	private String labelTownship;

	@Column(name = "LabelState", length = 120)
	private String labelState;

	@Column(name = "RecordType", columnDefinition = "ENUM('COUNTRY','STATE')", nullable = false, length = 7)
	private String recordType;

	@Column(name = "RecordActiveFlag", nullable = false)
	private byte recordActiveFlag;

}
