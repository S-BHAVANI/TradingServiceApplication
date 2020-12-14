package com.cg.tradingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.tradingservice.model.Investment;
import com.cg.tradingservice.model.Investor;



/** This is a repository interface for Investor details 
 * 
 * @author Akhil's
 *
 */
@Repository
public interface InvestorRepository extends JpaRepository<Investor , Integer>{

	Object save(Investment inv);

}
