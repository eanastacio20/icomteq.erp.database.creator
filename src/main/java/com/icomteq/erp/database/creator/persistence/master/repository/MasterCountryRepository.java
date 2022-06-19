package com.icomteq.erp.database.creator.persistence.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icomteq.erp.database.creator.persistence.master.model.MasterCountry;

public interface MasterCountryRepository extends JpaRepository<MasterCountry, String> {

}
