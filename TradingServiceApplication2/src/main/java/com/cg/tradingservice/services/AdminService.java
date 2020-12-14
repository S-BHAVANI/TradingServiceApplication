package com.cg.tradingservice.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.tradingservice.exception.ResourceNotFoundException;
import com.cg.tradingservice.model.CompanyManager;
import com.cg.tradingservice.model.Investor;




/** This is an Service interface which defines CRUD methods for Company Manager and Investor details
 * 
 * @author Bhavani's
 *
 */

public interface AdminService {
	CompanyManager createCompanyManager(CompanyManager companymanager);
	ResponseEntity<CompanyManager> updateCompanyManager(Integer companyManagerId, CompanyManager companymanagerDetails) throws ResourceNotFoundException;
	boolean deleteCompanyManager(Integer companyManagerId) throws ResourceNotFoundException;
	List<CompanyManager> getAllCompanyManager();

	
	Investor createInvestor(Investor investor);
    Investor updateInvestorById(Integer investorId, Investor investorDetails) throws ResourceNotFoundException;
	//boolean deleteInvestorById(Integer investorId) throws ResourceNotFoundException;
	List<Investor> getAllInvestor();
	CompanyManager findById(Integer companyManagerId);
	Investor findInvestorById(Integer investorId);
	boolean deleteInvestor(Integer investorId) throws ResourceNotFoundException;;
	
	
	 
}
