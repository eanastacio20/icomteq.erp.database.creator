package com.icomteq.erp.database.creator.database.creation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DatabaseCreateParam {

	private String shFile;
	private String host;
	private String username;
	private String password;
	private String templateDB;
	private String dumpFileDestination;
	private String newDatabaseName;
	private String characterSet;

}
