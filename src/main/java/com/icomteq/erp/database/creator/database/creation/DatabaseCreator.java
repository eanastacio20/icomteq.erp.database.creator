package com.icomteq.erp.database.creator.database.creation;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class DatabaseCreator {

	public final Logger log = LoggerFactory.getLogger(getClass());
	
	public abstract void createDatabase(DatabaseCreateParam databaseCreateParam) throws IOException;
	
}
