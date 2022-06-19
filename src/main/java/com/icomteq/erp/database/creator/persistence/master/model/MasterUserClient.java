package com.icomteq.erp.database.creator.persistence.master.model;

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
@Table(name = "MasterUserClient")
public class MasterUserClient {

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "userId", column = @Column(name = "UserID", nullable = false)),
			@AttributeOverride(name = "clientId", column = @Column(name = "ClientID", nullable = false))})
	private MasterUserClientId id;

}