package com.icomteq.erp.database.creator.persistence.master.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.icomteq.erp.database.creator.persistence.master.model.MasterUser;

@Repository
public interface MasterUserRepository extends JpaRepository<MasterUser, Integer> {

	Optional<MasterUser> findByEmailAddress(String emailAddress);
	Optional<MasterUser> findByUserNameOrEmailAddress(String userName, String emailAddress);
	Optional<MasterUser> findByUserName(String userName);
	Boolean existsByUserName(String userName);
	Boolean existsByEmailAddress(String emailAddress);
	Optional<MasterUser> findByPasswordChangeToken(String passwordChangeToken);
	Optional<MasterUser> findByPasswordExpires(String userName);
	Page<MasterUser> findByMasterUserType_UserTypeIdGreaterThanEqual(Short userTypeId, Pageable pageable);
	Page<MasterUser> findByUserStatusAndMasterUserType_UserTypeIdGreaterThanEqual(byte userStatus, Short userTypeId, Pageable pageable);
	Page<MasterUser> findByUserFullNameContainingAndMasterUserType_UserTypeIdGreaterThanEqual(String userFullName, Short userTypeId, Pageable pageable);
	Page<MasterUser> findByMasterUserType_UserTypeDescriptionContainingAndMasterUserType_UserTypeIdGreaterThanEqual(String userTypeDescription, Short userTypeId, Pageable pageable);
	Page<MasterUser> findByEmailAddressContainingAndMasterUserType_UserTypeIdGreaterThanEqual(String emailAddress, Short userTypeId,Pageable pageable);
	Page<MasterUser> findByUserFullNameContainsAndMasterUserType_UserTypeDescriptionContainsAndMasterUserType_UserTypeIdGreaterThanEqual(String userFullName, String userTypeDescription, Short userTypeId, Pageable pageable);
	Page<MasterUser> findByUserFullNameContainsAndMasterUserType_UserTypeDescriptionContainsAndEmailAddressContainsAndMasterUserType_UserTypeIdGreaterThanEqual(String userFullName, String userTypeDescription, String emailAddress, Short userTypeId,Pageable pageable);
	Page<MasterUser> findByUserFullNameContainsAndMasterUserType_UserTypeDescriptionContainsAndEmailAddressContainsAndUserStatusAndMasterUserType_UserTypeIdGreaterThanEqual(String userFullName, String userTypeDescription, String emailAddress, byte userStatus, Short userTypeId,Pageable pageable);
	Page<MasterUser> findByMasterUserType_UserTypeDescriptionContainsAndEmailAddressContainsAndMasterUserType_UserTypeIdGreaterThanEqual(String userTypeDescription, String emailAddress, Short userTypeId, Pageable pageable);
	Page<MasterUser> findByUserFullNameContainsAndEmailAddressContainsAndMasterUserType_UserTypeIdGreaterThanEqual(String userFullName, String emailAddress, Short userTypeId, Pageable pageable);
	
	@Query(value = "SELECT a.UserFullName FROM erp_master.MasterUser a \r\n"
			+ "INNER JOIN erp_master.MasterUserType b \r\n"
			+ "ON a.`UserTypeID` = b.`UserTypeID`\r\n"
			+ "WHERE a.`ClientID` = ?1 AND b.`UserTypeDescription` = 'CompanyAdmin'", nativeQuery = true)
	List<String> retrieveCompanyAdmin(Integer clientId);
}
