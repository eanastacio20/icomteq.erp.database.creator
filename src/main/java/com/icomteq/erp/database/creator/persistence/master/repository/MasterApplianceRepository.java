package com.icomteq.erp.database.creator.persistence.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icomteq.erp.database.creator.persistence.master.model.MasterAppliance;

@Repository
public interface MasterApplianceRepository extends JpaRepository<MasterAppliance, Integer> {

}
