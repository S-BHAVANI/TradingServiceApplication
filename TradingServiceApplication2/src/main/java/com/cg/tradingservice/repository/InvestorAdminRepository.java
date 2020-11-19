package com.cg.tradingservice.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.tradingservice.model.Investor;
import com.cg.tradingservice.services.impl.AdminServiceImpl;

@Repository
public interface InvestorAdminRepository extends  JpaRepository<Investor, Integer>  {
	
	 @Query("select i from Investor i where i.investorEmail=:investorEmail")
	    Investor findByEmail(String investorEmail);
	
	
}
