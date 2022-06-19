package com.icomteq.erp.database.creator.persistence.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icomteq.erp.database.creator.enums.CreationStatus;
import com.icomteq.erp.database.creator.persistence.master.model.MasterCompany;

@Repository
public interface MasterCompanyRepository extends JpaRepository<MasterCompany, Integer> {
	
	List<MasterCompany> findByCreationStatus(CreationStatus creationStatus);
	
}
