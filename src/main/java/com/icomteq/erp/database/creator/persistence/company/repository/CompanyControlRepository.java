package com.icomteq.erp.database.creator.persistence.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icomteq.erp.database.creator.persistence.company.model.CompanyControl;

@Repository
public interface CompanyControlRepository extends JpaRepository<CompanyControl, Integer> {

}
