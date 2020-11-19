package com.cg.tradingservice.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.tradingservice.controller.AdminController;
import com.cg.tradingservice.exception.ResourceNotFoundException;
import com.cg.tradingservice.model.CompanyManager;
import com.cg.tradingservice.model.Investor;
import com.cg.tradingservice.repository.CompanyManagerAdminRepository;
import com.cg.tradingservice.repository.InvestorAdminRepository;
import com.cg.tradingservice.services.AdminService;




@Service
@Transactional
public class AdminServiceImpl  implements AdminService {
	
	@Autowired
	private CompanyManagerAdminRepository companymanageradminRepository;
	

	@Autowired
	private InvestorAdminRepository investoradminRepository;
	
	private static final Logger logger = LogManager.getLogger(AdminServiceImpl.class);

	 public CompanyManager createCompanyManager( @RequestBody CompanyManager companymanager) {
			return  companymanageradminRepository.save(companymanager);
		}
	 
	 public CompanyManager updateCompanyManager(@PathVariable(value = "id") Integer companyManagerId,
			 @RequestBody CompanyManager companymanagerDetails) throws ResourceNotFoundException {
		CompanyManager companymanager = companymanageradminRepository.findById(companyManagerId)
				.orElseThrow(() -> new ResourceNotFoundException("Company Manager not found for this id :: " + companyManagerId));
		companymanager.setCompanyManagerId(companymanagerDetails.getCompanyManagerId());
		companymanager.setCompanyManagerCompanyName(companymanagerDetails.getCompanyManagerCompanyName());
		companymanager.setCompanyManagerEmail(companymanagerDetails.getCompanyManagerEmail());
		companymanager.setCompanyManagerPhone(companymanagerDetails.getCompanyManagerPhone());
		final CompanyManager updatedCompanyManager = companymanageradminRepository.save(companymanager);
		return updatedCompanyManager; 
		
	}  
	 
	 public boolean deleteCompanyManager(@PathVariable(value = "id") Integer companyManagerId)
				throws ResourceNotFoundException {
		 CompanyManager companymanager = companymanageradminRepository.findById(companyManagerId)           
					.orElseThrow(() -> new ResourceNotFoundException("Company Manager not found for this id :: " + companyManagerId));

			companymanageradminRepository.delete(companymanager);
			return true;
	}
	 
	 public List<CompanyManager> getAllCompanyManager() {
			return companymanageradminRepository.findAll();
		} 
	
	
	 
	 public Investor createInvestor( @RequestBody Investor investor) {
			return  investoradminRepository.save(investor);
		}	

	 public Investor updateInvestorById(@PathVariable(value = "id") Integer investorId,
			 @RequestBody Investor investorDetails) throws ResourceNotFoundException {
		Investor investor = investoradminRepository.findById(investorId)
				.orElseThrow(() -> new ResourceNotFoundException("Investor not found for this id :: " + investorId));
		investor.setInvestorId(investorDetails.getInvestorId());
		investor.setInvestorName(investorDetails.getInvestorName());
		investor.setInvestorPannum(investorDetails.getInvestorPannum());
		investor.setInvestorName(investorDetails.getInvestorName());
		investor.setInvestorEmail(investorDetails.getInvestorEmail());
		investor.setInvestorPhone(investorDetails.getInvestorPhone());
		final Investor updatedInvestor = investoradminRepository.save(investor);
		return updatedInvestor; 
	} 
	 
	 public boolean deleteInvestorById(@PathVariable(value = "id") Integer investorId)
				throws ResourceNotFoundException {
		 Investor investor = investoradminRepository.findById(investorId)
					.orElseThrow(() -> new ResourceNotFoundException("Investor not found for this id :: " + investorId));
		 investoradminRepository.findById(investorId).get();
			investoradminRepository.delete(investor);
			return true;
	}
	
	 public List<Investor> getAllInvestor() {
			 return investoradminRepository.findAll();
			}
	 
	@Override
	public Investor updateInvestorEmailbyId(Integer investorId, String investorEmail) {
		Investor investor=investoradminRepository.findById(investorId).get();
		investor.setInvestorEmail(investorEmail);
		return investoradminRepository.save(investor) ;
	}

	@Override
	public Investor findInvestorByEmail(String investorEmail) {
		// TODO Auto-generated method stub
		return  investoradminRepository.findByEmail(investorEmail);
	}



}
