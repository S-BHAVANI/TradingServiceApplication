package com.cg.tradingservice.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.tradingservice.model.Investor;



/** This is a repository interface for Investor Admin details 
 * 
 * @author Bhavani's
 *
 */
@Repository
public interface InvestorAdminRepository extends  JpaRepository<Investor, Integer>  {
	
	
	
}
