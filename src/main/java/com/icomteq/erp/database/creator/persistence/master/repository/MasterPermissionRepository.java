package com.icomteq.erp.database.creator.persistence.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icomteq.erp.database.creator.persistence.master.model.MasterPermission;
import com.icomteq.erp.database.creator.persistence.master.model.MasterPermissionId;

@Repository
public interface MasterPermissionRepository extends JpaRepository<MasterPermission, MasterPermissionId>{
	
}
