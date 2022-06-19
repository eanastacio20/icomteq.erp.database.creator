package com.icomteq.erp.database.creator.persistence.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icomteq.erp.database.creator.persistence.master.model.MasterModuleTree;
import com.icomteq.erp.database.creator.persistence.master.model.MasterModuleTreeId;

@Repository
public interface MasterModuleTreeRepository extends JpaRepository<MasterModuleTree, MasterModuleTreeId> {

}
