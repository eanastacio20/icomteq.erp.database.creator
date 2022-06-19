package com.icomteq.erp.database.creator.persistence.master.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class MasterUserClientId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "UserID", nullable = false)
	private int userId;

	@Column(name = "ClientID", nullable = false)
	private int clientId;

}