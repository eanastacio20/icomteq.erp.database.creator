package com.icomteq.erp.database.creator.services.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.icomteq.erp.database.creator.configuration.ISIHrisApplicationProperties;
import com.icomteq.erp.database.creator.database.creation.DatabaseCreateParam;
import com.icomteq.erp.database.creator.database.creation.DatabaseCreator;
import com.icomteq.erp.database.creator.enums.CreationStatus;
import com.icomteq.erp.database.creator.enums.FileSystem;
import com.icomteq.erp.database.creator.persistence.company.configuration.DataSourceRouting;
import com.icomteq.erp.database.creator.persistence.company.model.CompanyControl;
import com.icomteq.erp.database.creator.persistence.company.repository.CompanyControlRepository;
import com.icomteq.erp.database.creator.persistence.master.model.MasterAppliance;
import com.icomteq.erp.database.creator.persistence.master.model.MasterCompany;
import com.icomteq.erp.database.creator.persistence.master.repository.MasterApplianceRepository;
import com.icomteq.erp.database.creator.persistence.master.repository.MasterCompanyRepository;
import com.icomteq.erp.database.creator.services.DatabaseCreatorService;

@Service
@Lazy
public class DatabaseCreatorServiceImpl implements DatabaseCreatorService {

	public final Logger log = LoggerFactory.getLogger(getClass());

	DatabaseCreator dbCreator;

	ISIHrisApplicationProperties appProperties;

	MasterCompanyRepository masterCompanyRepository;

	MasterApplianceRepository masterApplianceRepository;

	CompanyControlRepository companyControlRepository;

	DataSourceRouting dataSourceRouting;

	@Autowired
	@Qualifier("companyEntityManager")
	EntityManager cem;

	public DatabaseCreatorServiceImpl(DatabaseCreator dbCreator, ISIHrisApplicationProperties appProperties,
			MasterCompanyRepository masterCompanyRepository, MasterApplianceRepository masterApplianceRepository,
			DataSourceRouting dataSourceRouting, CompanyControlRepository companyControlRepository) {

		this.dbCreator = dbCreator;
		this.appProperties = appProperties;
		this.masterCompanyRepository = masterCompanyRepository;
		this.masterApplianceRepository = masterApplianceRepository;
		this.dataSourceRouting = dataSourceRouting;
		this.companyControlRepository = companyControlRepository;
	}

	@Override
	@Transactional
	public void startJob() {

		List<MasterCompany> list = masterCompanyRepository.findByCreationStatus(CreationStatus.QUEUED);

		for (MasterCompany mc : list) {
			log.info("==================== START DATABASE CREATION ====================");
			log.info("COMPANY NAME : " + mc.getCompanyName());
			if (!ObjectUtils.isEmpty(mc.getCompanyApplianceId())) {
				Optional<MasterAppliance> oma = masterApplianceRepository.findById(mc.getCompanyApplianceId());
				if (oma.isPresent()) {
					try {
						mc.setCreationStatus(CreationStatus.IN_PROGRESS);
						masterCompanyRepository.save(mc);
						MasterAppliance ma = oma.get();
						String dbCreatorScript = appProperties.getFileSystemOS().equals(FileSystem.LINUX.getValue())
								? appProperties.getDatabaseCreatorScriptLinux()
								: appProperties.getDatabaseCreatorScriptWindows();
						String newDatabaseName = String.format("%010d_erpcompany", mc.getCompanyId());
						createDatabase(ma.getIpaddress(), ma.getConnectionUserId(), ma.getConnectionPassword(),
								ma.getDatabaseName(), dbCreatorScript, newDatabaseName, "utf8");
						mc.setCreationStatus(CreationStatus.COMPLETED);
						masterCompanyRepository.save(mc);
						switchCompany(mc.getCompanyId(), newDatabaseName, ma);
						updateCompanyDBTables(mc);
					} catch (Exception ex) {
						log.error("{}", ex);
						mc.setCreationStatus(CreationStatus.ABORTED);
						mc.setRemarks(String.format("%s %s due to \n%s", mc.getCompanyName(), mc.getCreationStatus(), ex));
						masterCompanyRepository.save(mc);
					}
				}
			}
			log.info("====================  END DATABASE CREATION  ====================");
		}

	}

	@Override
	public void createDatabase(String host, String username, String password, String dbTemplate,
			String dumpFileDestination, String newDatabaseName, String characterSet) throws IOException {

		File file = new File(dumpFileDestination);
		
		if (file.exists()) {
			String shFile = file.toString();
			DatabaseCreateParam dbParam = new DatabaseCreateParam();
			dbParam.setShFile(shFile);
			dbParam.setHost(host);
			dbParam.setUsername(username);
			dbParam.setPassword(password);
			dbParam.setTemplateDB(dbTemplate);
			dbParam.setDumpFileDestination(String.format("%s.sql", newDatabaseName));
			dbParam.setNewDatabaseName(newDatabaseName);
			dbParam.setCharacterSet(characterSet);
			dbCreator.createDatabase(dbParam);
		}
		
	}

	public boolean switchCompany(Integer companyId, String dbName, MasterAppliance ma){
		boolean success = false;
		Optional<MasterCompany> mc = masterCompanyRepository.findById(companyId);
		if (mc.isPresent()) {
			String jdbcUrl = String.format("jdbc:mysql://%s:%s/%s", ma.getIpaddress(), ma.getHostPort(), dbName);
			dataSourceRouting.setSelectedCompany(dbName);
			dataSourceRouting.switchDb(dbName, jdbcUrl, ma.getConnectionUserId(), ma.getConnectionPassword(),
					appProperties.getMasterDatasourceDriverClassName());
			success = true;
		}
		return success;
	}

	private void updateCompanyDBTables(MasterCompany mc) {
		
		insertCompanyControl(mc);
		
	}

	private void insertCompanyControl(MasterCompany mc) {
		CompanyControl cc = new CompanyControl();
		cc.setControlKey(mc.getCompanyId());
		cc.setCompanyName(mc.getCompanyName());
		cc.setCreatedTimeStamp(new Date());
		cc.setWeightUm("LBS");
		cc.setHeightUm("INCHES");
		cc.setRecordActiveFlag((byte) 1);
		companyControlRepository.save(cc);
	}

}
