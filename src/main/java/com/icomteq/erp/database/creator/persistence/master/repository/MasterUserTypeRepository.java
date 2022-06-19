package com.icomteq.erp.database.creator.persistence.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icomteq.erp.database.creator.persistence.master.model.MasterUserType;

public interface MasterUserTypeRepository extends JpaRepository<MasterUserType, Short> {
	
}
