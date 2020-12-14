package com.cg.tradingservice.services.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.tradingservice.controller.AdminController;
import com.cg.tradingservice.exception.ResourceNotFoundException;
import com.cg.tradingservice.model.CompanyManager;
import com.cg.tradingservice.model.Investor;
import com.cg.tradingservice.repository.CompanyManagerAdminRepository;
import com.cg.tradingservice.repository.InvestorAdminRepository;
import com.cg.tradingservice.services.AdminService;



/** The AdminServiceImpl class provides access to repository CRUD methods for Company Manager and Investor details
 * 
 * 
 * @author Bhavani's
 *
 */

@Service
@Transactional
public class AdminServiceImpl  implements AdminService {
	
	private static final Logger logger = LogManager.getLogger(AdminServiceImpl.class);
	
	@Autowired
	private CompanyManagerAdminRepository companymanageradminRepository;
	

	@Autowired
	private InvestorAdminRepository investoradminRepository;
	
	

	 public CompanyManager createCompanyManager( @RequestBody CompanyManager companymanager) {
			return  companymanageradminRepository.save(companymanager);
		}
	 
	 public ResponseEntity<CompanyManager> updateCompanyManager(@PathVariable(value = "id") Integer companyManagerId,
			 @RequestBody CompanyManager companymanagerDetails) throws ResourceNotFoundException {
		CompanyManager companymanager = companymanageradminRepository.findById(companyManagerId)
				.orElseThrow(() -> new ResourceNotFoundException("Company Manager not found for this id :: " + companyManagerId));
		companymanager.setCompanyManagerId(companymanagerDetails.getCompanyManagerId());
		companymanager.setCompanyManagerCompanyName(companymanagerDetails.getCompanyManagerCompanyName());
		companymanager.setCompanyManagerEmail(companymanagerDetails.getCompanyManagerEmail());
		companymanager.setCompanyManagerPhone(companymanagerDetails.getCompanyManagerPhone());
	           CompanyManager updatedCompanyManager=companymanageradminRepository.save(companymanager);
	  return ResponseEntity.ok(updatedCompanyManager);
		 
		
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
	   return  investoradminRepository.save(investor);
		
	} 
	 
//	 public boolean  deleteInvestorById(@PathVariable(value = "id") Integer investorId)
//				throws ResourceNotFoundException {
//		 Investor investor = investoradminRepository.findById(investorId)
//					.orElseThrow(() -> new ResourceNotFoundException("Investor not found for this id :: " + investorId));
//		 investoradminRepository.findById(investorId);
//			investoradminRepository.delete(investor);
//			return true;
//	} 
	 
	
	 @Override
		public boolean deleteInvestor(Integer investorId) throws ResourceNotFoundException {
			// TODO Auto-generated method stub
		 investoradminRepository.deleteById(investorId);
			return false;
		}

	
	
	 public List<Investor> getAllInvestor() {
			 return investoradminRepository.findAll();
			}

	@Override
	public CompanyManager findById(Integer companyManagerId) {
		// TODO Auto-generated method stub
	  return companymanageradminRepository.findById(companyManagerId).get();
	}

	@Override
	public Investor findInvestorById(Integer investorId) {
		// TODO Auto-generated method stub
		return investoradminRepository.findById(investorId).get();
	}

	

	

	

	

}
