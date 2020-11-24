package com.cg.tradingservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.tradingservice.model.CompanyManager;



/** This is a repository interface for Company Manager Admin details 
 * 
 * @author Bhavani's
 *
 */

@Repository
public interface CompanyManagerAdminRepository extends  JpaRepository<CompanyManager, Integer>  {

	
	@Query(value="select * from CompanyManager where CompanyManager_Id=?1",nativeQuery=true)
	  CompanyManager findCompanyManagerById(Integer companyManagerId);
	
	
}
