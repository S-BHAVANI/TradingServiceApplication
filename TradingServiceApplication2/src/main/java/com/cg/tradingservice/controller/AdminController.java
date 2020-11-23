package com.cg.tradingservice.controller;

import java.util.List;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

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


/** This is a Controller class for Admin details 
 * 
 * @author Bhavani's
 *  @version 2.0
 *
 */


@RestController
@RequestMapping("/api/v2")
public class AdminController {

	
	private static final Logger logger = LogManager.getLogger(AdminController.class);

	@Autowired
	private AdminService adminService;
	
	
	
	/** This method adds the Company Manager details 
	 * 
	 * @param delivery - Company Manager entity details
	 * 
	 * 
	 */
	
	@PostMapping("/CreateCompanyManager")
	public CompanyManager createCompanyManger( @RequestBody CompanyManager companymanager) {
		logger.info("creating companymanager");
		return adminService.createCompanyManager(companymanager);
	} 
	
	
	
	/** This method changes the Company Manager details 
	 * 
	 * @param delivery - Company Manager entity details
	 * 
	 * 
	 */
	
	
	@PutMapping("/CompanyManager/{id}")
	public CompanyManager updateCompanyManager(@PathVariable(value = "id") Integer companyManagerId,
			 @RequestBody CompanyManager companymanagerDetails) throws ResourceNotFoundException {
		CompanyManager companymanager = adminService.updateCompanyManager(companyManagerId, companymanagerDetails);
		logger.info("Updating Company Manager Details");
		return  companymanager;
	}  

	
	
	/** This method deletes the Company Manager details 
	 * 
	 * @param delivery - Company Manager Id details
	 * 
	 * 
	 */
	
	@DeleteMapping("/CompanyManager/{id}")	
	public boolean deleteCompanyManager(@PathVariable(value = "id") Integer companyManagerId) throws ResourceNotFoundException	{
		
		 adminService.deleteCompanyManager(companyManagerId);
		logger.info("Deleting Company Manager Details");
		return  true;
	}
	
	
	
	/** This method returns list of all Company Manager details 
	 * 
	 * @return list of all Company Manager details
	 * 
	 * 
	 */
	
	@GetMapping("/CompanyManager")
	public List<CompanyManager> getAllCompanyManager() {
		logger.info("Get all Company Managers");
		return adminService.getAllCompanyManager();
	} 
	

	
	/** This method returns list of all Investor details 
	 * 
	 * @return list of all Investor details
	 * 
	 * 
	 */
	
	@GetMapping("/Investor")
	public List<Investor> getAllInvestor() {
		logger.info("Get all investors");
		return adminService.getAllInvestor();
	} 
	
	
	
	/** This method adds the Investor details 
	 * 
	 * @param delivery - Investor entity details
	 * 
	 * 
	 */
	
	@PostMapping("/CreateInvestor")
	public Investor createInvestor( @RequestBody Investor investor) {
		logger.info("creating investor");
		return adminService.createInvestor(investor);
		
	} 
	
	
	/** This method changes the Investor details 
	 * 
	 * @param delivery - Investor entity details
	 * 
	 * 
	 */
	
	@PutMapping("/Investor/{id}")
	public Investor updateInvestorById(@PathVariable(value = "id") Integer investorId,
			 @RequestBody Investor investorDetails) throws ResourceNotFoundException {
		Investor  investor = adminService.updateInvestorById(investorId, investorDetails);
		logger.info("updating investor details");
		return  investor;
	}  
	
	
	
	/** This method deletes the Investor details 
	 * 
	 * @param delivery - Investor Id details
	 * 
	 * 
	 */
	

	@DeleteMapping("/Investor/{id}")	
	public boolean deleteInvestorById(@PathVariable(value = "id") Integer investorId,
			 @RequestBody Investor investorDetails) throws ResourceNotFoundException	{
		adminService.deleteInvestorById(investorId);
		logger.info("Deleting investor details");
		return true;
		
	}  


	
	



}
