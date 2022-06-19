package com.icomteq.erp.database.creator.cron;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.icomteq.erp.database.creator.services.DatabaseCreatorService;

@Component
public class SchedulerController {

	public final Logger log = LoggerFactory.getLogger(getClass());

	DatabaseCreatorService databaseCreatorService;

	@Autowired
	public SchedulerController(DatabaseCreatorService databaseCreatorService) {
		this.databaseCreatorService = databaseCreatorService;
	}

	@Scheduled(fixedRate = 3000)
	public void fixedRateSch() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String strDate = sdf.format(now);
		log.info("HEART BEAT of DB Creation :" + strDate);
		synchronized (this) {
			this.databaseCreatorService.startJob();
		}
	}

}
