package com.cg.tradingservice.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.cg.tradingservice.exception.ResourceNotFoundException;
import com.cg.tradingservice.model.CompanyManager;
import com.cg.tradingservice.model.Investor;





public interface AdminService {
	CompanyManager createCompanyManager(CompanyManager companymanager);
	CompanyManager updateCompanyManager(Integer companyManagerId, CompanyManager companymanagerDetails) throws ResourceNotFoundException;
	boolean deleteCompanyManager(Integer companyManagerId) throws ResourceNotFoundException;
	List<CompanyManager> getAllCompanyManager();

	
	Investor createInvestor(Investor investor);
    Investor updateInvestorById(Integer investorId, Investor investorDetails) throws ResourceNotFoundException;
	boolean deleteInvestorById(Integer investorId) throws ResourceNotFoundException;
	List<Investor> getAllInvestor();
	Investor updateInvestorEmailbyId(Integer investorId, String investorEmail);
	Investor findInvestorByEmail(String investorEmail);
	
	 
}
