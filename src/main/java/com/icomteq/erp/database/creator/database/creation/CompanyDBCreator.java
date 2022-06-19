package com.icomteq.erp.database.creator.database.creation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icomteq.erp.database.creator.util.ShExecutor;

@Component
public class CompanyDBCreator extends DatabaseCreator {

	@Autowired
	ShExecutor shExecutor;

	@Override
	public void createDatabase(DatabaseCreateParam dbParams) throws IOException {
		executeShellScript(dbParams.getShFile(), dbParams.getHost(), dbParams.getUsername(), dbParams.getPassword(),
				dbParams.getTemplateDB(), dbParams.getDumpFileDestination(), dbParams.getNewDatabaseName(),
				dbParams.getCharacterSet());

	}

	private void executeShellScript(String shFile, String host, String username, String password, String dbTemplate,
			String dumpFileDestination, String newDatabaseName, String characterSet) throws IOException {

		List<String> params = new ArrayList<>();
		params.add(shFile);
		params.add(host);
		params.add(username);
		params.add(password);
		params.add(dbTemplate);
		params.add(dumpFileDestination);
		params.add(newDatabaseName);
		params.add(characterSet);
		log.debug("PARAMS : {}" + params);
		shExecutor.executeShellScript(params);

	}

}
