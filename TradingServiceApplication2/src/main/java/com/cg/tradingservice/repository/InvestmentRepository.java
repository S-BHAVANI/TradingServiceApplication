package com.cg.tradingservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.tradingservice.model.Investment;


/** This is a repository interface for Investment details 
 * 
 * @author Akhil's
 *
 */
@Repository
public interface InvestmentRepository extends  JpaRepository<Investment, Integer> {


	public List<Investment> findByinvestmentInvestorId(int investorId);

}
