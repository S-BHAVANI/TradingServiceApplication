package com.cg.tradingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.tradingservice.model.Stock;


/** This is a repository interface for Company Manager details 
 * 
 * @author Kavya's
 *
 */

@Repository
public interface CompanyManagerRepository extends  JpaRepository<Stock, Integer> {

}

