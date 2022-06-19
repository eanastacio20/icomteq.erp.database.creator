package com.icomteq.erp.database.creator.persistence.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.icomteq.erp.database.creator.persistence.master.model.MasterModule;

@Repository
public interface MasterModuleRepository extends JpaRepository<MasterModule, Short> {

	@Query(value = "SELECT * FROM MasterModule a WHERE a.ParentModuleID = a.ModuleID AND a.MenuLevel = 1 AND ShowInNavigationMenu = 1 AND RecordActiveFlag = 1 AND ModuleID IN (SELECT MemberModuleID FROM MasterPermission WHERE MemberModuleID = a.ModuleID AND UserTypeID = ?1)", nativeQuery = true)
	List<MasterModule> retrieveMasterModuleMenuLevelOne(Short userType);
	
	@Query(value = "SELECT * FROM MasterModule a WHERE a.ParentModuleID <> a.ModuleID AND ShowInNavigationMenu = 1 AND RecordActiveFlag = 1 AND ModuleID IN (SELECT MemberModuleID FROM MasterPermission WHERE ModuleID = ?1 AND UserTypeID = ?2)", nativeQuery = true)
	List<MasterModule> retrieveModuleChildren(Short moduleId, Short userTypeId);
	
	@Query(value = "SELECT COUNT(a.ModuleId) FROM MasterModule a WHERE a.ParentModuleID <> a.ModuleID AND ShowInNavigationMenu = 1 AND RecordActiveFlag = 1 AND ModuleID IN (SELECT MemberModuleID FROM MasterPermission WHERE ModuleID = ?1 AND UserTypeID = ?2)", nativeQuery = true)
	Long countChildren(Short moduleId, Short userTypeId);
	
	@Query(value = "SELECT * FROM MasterModule a "
			+ "WHERE a.ModuleID = a.ParentModuleID AND a.MenuLevel = 1 AND RecordActiveFlag = 1 AND a.ModuleID IN ("
			+ "SELECT b.ModuleId FROM MasterPermission b "
			+ "WHERE b.UserTypeID = ?1 AND ModuleID IN ("
			+ "SELECT c.ModuleID FROM MasterClientPermission c "
			+ "WHERE c.ClientID = ?2 AND  c.ModuleID = a.ModuleID AND c.EnabledFlag = 1))", nativeQuery = true)
	List<MasterModule> retrieveMasterModuleMenuLevelOneByClient(Short userType, Integer clientId);
	
	@Query(value = "SELECT * FROM MasterModule a "
			+ "WHERE a.ModuleID <> a.ParentModuleID AND RecordActiveFlag = 1 AND a.ModuleID IN ("
			+ "SELECT b.MemberModuleId FROM MasterPermission b "
			+ "WHERE b.UserTypeID = ?2 AND b.ModuleID <> b.MemberModuleID AND MemberModuleID IN ("
			+ "SELECT c.MemberModuleId FROM MasterClientPermission c "
			+ "WHERE c.ClientID = ?3 AND c.ModuleId = ?1 AND c.EnabledFlag = 1 AND c.ModuleID <> c.MemberModuleID))", nativeQuery = true)
	List<MasterModule> retrieveModuleChildrenByClient(Short moduleId, Short userTypeId, Integer clientId);
	
	
	
	@Query(value = "SELECT * FROM MasterModule a "
			+ "WHERE a.ModuleID = a.ParentModuleID AND a.MenuLevel = 1 AND RecordActiveFlag = 1 AND a.ModuleID IN ("
			+ "SELECT b.ModuleId FROM MasterPermission b "
			+ "WHERE b.UserTypeID = ?1 AND ModuleID IN ("
			+ "SELECT DISTINCT c.ModuleID FROM MasterCompanyPermission c "
			+ "WHERE c.CompanyID = ?2 AND c.ModuleID = a.ModuleID AND c.EnabledFlag = 1))", nativeQuery = true)
	List<MasterModule> retrieveMasterModuleMenuLevelOneByCompany(Short userType, Integer companyId);
	
	@Query(value = "SELECT * FROM MasterModule a "
			+ "WHERE a.ModuleID <> a.ParentModuleID AND RecordActiveFlag = 1 AND a.ModuleID IN ("
			+ "SELECT b.MemberModuleId FROM MasterPermission b "
			+ "WHERE b.UserTypeID = ?2 AND b.ModuleID <> b.MemberModuleID AND MemberModuleID IN ("
			+ "SELECT c.MemberModuleId FROM MasterCompanyPermission c "
			+ "WHERE c.CompanyID = ?3 AND c.ModuleId = ?1 AND c.EnabledFlag = 1 AND c.ModuleID <> c.MemberModuleID))", nativeQuery = true)
	List<MasterModule> retrieveModuleChildrenByCompany(Short moduleId, Short userTypeId, Integer companyId);
	
}
