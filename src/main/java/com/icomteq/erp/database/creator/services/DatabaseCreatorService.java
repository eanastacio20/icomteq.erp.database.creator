package com.icomteq.erp.database.creator.services;

import java.io.IOException;

public interface DatabaseCreatorService {
	
	void startJob();

	void createDatabase(String host, String username, String password, String dbTemplate,
			String dumpFileDestination, String newDatabaseName, String characterSet) throws IOException;
	
}
