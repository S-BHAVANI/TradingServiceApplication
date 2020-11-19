package com.cg.tradingservice.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.tradingservice.model.CompanyManager;
import com.cg.tradingservice.model.Investor;


@Repository
public interface CompanyManagerAdminRepository extends  JpaRepository<CompanyManager, Integer>  {

	
	
	
	
}
