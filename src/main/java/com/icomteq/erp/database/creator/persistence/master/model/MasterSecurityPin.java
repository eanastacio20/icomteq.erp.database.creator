package com.icomteq.erp.database.creator.persistence.master.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
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
@Table(name = "MasterSecurityPin")
public class MasterSecurityPin {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "GenID", unique = true, nullable = false)
	private Integer genId;
	
	@Column(name = "PinCode", nullable = false, length = 6)
	private String pinCode;
	
	@Column(name = "UserID", nullable = false)
	private int userId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreatedTimestamp", nullable = false, length = 26)
	private Date createdTimestamp;
	
}
