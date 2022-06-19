package com.icomteq.erp.database.creator.persistence.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icomteq.erp.database.creator.persistence.master.model.MasterUserCompany;
import com.icomteq.erp.database.creator.persistence.master.model.MasterUserCompanyId;

@Repository
public interface MasterUserCompanyRepository extends JpaRepository<MasterUserCompany, MasterUserCompanyId> {

	List<MasterUserCompany> findById_UserId(Integer userId);
	
}
