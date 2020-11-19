package com.cg.tradingservice.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tradingservice.exception.ResourceNotFoundException;
import com.cg.tradingservice.model.CompanyManager;
import com.cg.tradingservice.model.Investor;
import com.cg.tradingservice.services.AdminService;

@RestController
@RequestMapping("/api/v2")
public class AdminController {
	
	
	private static final Logger logger = LogManager.getLogger(AdminController.class);

	@Autowired
	private AdminService adminService;
	
	 @PutMapping("/updateInvestorbyId/{email:.+}/investor/{investorId}")
	 public Investor updateInvestorById(@PathVariable String investorEmail, @PathVariable Integer investorId){
		 return adminService.updateInvestorEmailbyId(investorId, investorEmail);
	 }

	    
	    
	    @GetMapping("/getTicketByEmail/{email:.+}")
	    public Investor getInvestorByEmail(String investorEmail) {
	        return adminService.findInvestorByEmail(investorEmail);
	    }

	
	@PostMapping("/CreateCompanyManager")
	public CompanyManager createCompanyManger( @RequestBody CompanyManager companymanager) {
		logger.info("creating companymanager");
		return adminService.createCompanyManager(companymanager);
	} 
	
	@PutMapping("/CompanyManager/{id}")
	public CompanyManager updateCompanyManager(@PathVariable(value = "id") Integer companyManagerId,
			 @RequestBody CompanyManager companymanagerDetails) throws ResourceNotFoundException {
		CompanyManager companymanager = adminService.updateCompanyManager(companyManagerId, companymanagerDetails);
		logger.info("Updating Company Manager Details");
		return  companymanager;
	}  


	@DeleteMapping("/CompanyManager/{id}")	
	public ResponseEntity<Boolean> deleteCompanyManager(@PathVariable(value = "id") Integer companyManagerId) throws ResourceNotFoundException	{
		
		boolean companymanager = adminService.deleteCompanyManager(companyManagerId);
		logger.info("Deleting Company Manager Details");
		return  ResponseEntity.ok(companymanager);
	}
	
	@GetMapping("/CompanyManager")
	public List<CompanyManager> getAllCompanyManager() {
		logger.info("Get all Company Managers");
		return adminService.getAllCompanyManager();
	} 
	
	@GetMapping("/Investor")
	public List<Investor> getAllInvestor() {
		logger.info("Get all investors");
		return adminService.getAllInvestor();
	} 
	
	@PostMapping("/CreateInvestor")
	public Investor createInvestor( @RequestBody Investor investor) {
		logger.info("creating investor");
		return adminService.createInvestor(investor);
		
	} 
	
	@PutMapping("/Investor/{id}")
	public Investor updateInvestorById(@PathVariable(value = "id") Integer investorId,
			 @RequestBody Investor investorDetails) throws ResourceNotFoundException {
		Investor  investor = adminService.updateInvestorById(investorId, investorDetails);
		logger.info("updating investor details");
		return  investor;
	}  

	@DeleteMapping("/deleteInvestor/{id}")	
	public boolean deleteInvestorById(@PathVariable(value = "id") Integer investorId,
			 @RequestBody Investor investorDetails) throws ResourceNotFoundException	{
		boolean investor = adminService.deleteInvestorById(investorId);
		logger.info("Deleting investor details");
		return true;
	}  

	@PutMapping("/updateInvestorbyId/{email:.+}/Investor/{investorId}")
	public Investor updateInvestorEmailbyId(@PathVariable String investorEmail, @PathVariable Integer investorId) {
		return adminService.updateInvestorEmailbyId(investorId, investorEmail);
	}
	
	



}
