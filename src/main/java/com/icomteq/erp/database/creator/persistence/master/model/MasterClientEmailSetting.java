package com.icomteq.erp.database.creator.persistence.master.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "MasterClientEmailSetting")
public class MasterClientEmailSetting {

	private MasterClientEmailSettingId id;

	public MasterClientEmailSetting() {
	}

	public MasterClientEmailSetting(MasterClientEmailSettingId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "clientId", column = @Column(name = "ClientID", nullable = false)),
			@AttributeOverride(name = "supportEmailAddress", column = @Column(name = "SupportEmailAddress", length = 120)),
			@AttributeOverride(name = "smtphost", column = @Column(name = "SMTPHost", length = 10)),
			@AttributeOverride(name = "smtpport", column = @Column(name = "SMTPPort")),
			@AttributeOverride(name = "smtpuserName", column = @Column(name = "SMTPUserName", length = 120)),
			@AttributeOverride(name = "smtppassword", column = @Column(name = "SMTPPassword", length = 120)),
			@AttributeOverride(name = "smtpstartTls", column = @Column(name = "SMTPStartTLS", nullable = false)),
			@AttributeOverride(name = "smtpauth", column = @Column(name = "SMTPAuth", nullable = false)),
			@AttributeOverride(name = "smtptls", column = @Column(name = "SMTPTLS", nullable = false)),
			@AttributeOverride(name = "smtpdebug", column = @Column(name = "SMTPDebug", nullable = false))})
	public MasterClientEmailSettingId getId() {
		return this.id;
	}

	public void setId(MasterClientEmailSettingId id) {
		this.id = id;
	}

}
