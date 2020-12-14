package com.cg.tradingservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/** This is a Controller class for Admin details 
 * 
 * @author Bhavani's
 *  @version 2.0
 *
 */
@CrossOrigin(origins = "http://localhost:3000")
@Api(value = "AdminController", description = "REST Apis related to Company Manager and Investor Entity!!!!")
@RestController
@RequestMapping("/api/v2")
public class AdminController {

	
	private static final Logger logger = LogManager.getLogger(AdminController.class);

	@Autowired
	private AdminService adminService;
	
	
	@ApiOperation(value = "Creating specific Company Manager in the System ", response = CompanyManager.class)
	/** This method adds the Company Manager details 
	 * 
	 * @param delivery - Company Manager entity details
	 * 
	 * 
	 */
	
	@PostMapping("/CompanyManager")
	public CompanyManager createCompanyManager( @RequestBody CompanyManager companymanager) {
		logger.info("creating companymanager");
		return adminService.createCompanyManager(companymanager);
	} 
	
	
	@ApiOperation(value = "Updating specific Company Manager in the System ", response = CompanyManager.class)
	/** This method changes the Company Manager details 
	 * 
	 * @param delivery - Company Manager entity details
	 * 
	 * 
	 */
	
	
	@PutMapping("/CompanyManager/{id}")
	public ResponseEntity<ResponseEntity<CompanyManager>> updateCompanyManager(@PathVariable(value = "id") Integer companyManagerId,
			 @RequestBody CompanyManager companymanagerDetails) throws ResourceNotFoundException {
		ResponseEntity<CompanyManager> companymanager = adminService.updateCompanyManager(companyManagerId, companymanagerDetails);
		logger.info("Updating Company Manager Details");
		return ResponseEntity.ok(companymanager);
	}  

	
	@ApiOperation(value = "delete specific Company Manager in the System ", response = CompanyManager.class)
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
	
	@ApiOperation(value = "Get list of Company Managers in the System ", response = Iterable.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), 
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	
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
	
	// get employee by id rest api
	@GetMapping("/CompanyManager/{id}")
	public ResponseEntity<CompanyManager> getCompanyManagerById(@PathVariable(value = "id") Integer companyManagerId) {
		CompanyManager companymanager = adminService.findById(companyManagerId);
		return ResponseEntity.ok(companymanager);
	}
	
	
	@ApiOperation(value = "Get list of Investors in the System ", response = Iterable.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), 
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	
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
	
	
	@ApiOperation(value = "Creating specific Investor in the System ", response = Investor.class)
	/** This method adds the Investor details 
	 * 
	 * @param delivery - Investor entity details
	 * 
	 * 
	 */
	
	@PostMapping("/Investor")
	public Investor createInvestor( @RequestBody Investor investor) {
		logger.info("creating investor");
		return adminService.createInvestor(investor);
		
	} 
	
	@ApiOperation(value = "Update specific Investor in the System ", response = Investor.class)
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
	

	@ApiOperation(value = "delete specific Investor in the System ", response = Investor.class)
	/** This method deletes the Investor details 
	 * 
	 * @param delivery - Investor Id details
	 * 
	 * 
	 */
	

     @DeleteMapping("/Investor/{investorId}")	
	public boolean deleteInvestor(@PathVariable Integer investorId)
			throws ResourceNotFoundException	{
		return adminService.deleteInvestor(investorId);
	}  
	
	
	
	// get employee by id rest api
		@GetMapping("/Investor/{id}")
		public ResponseEntity<Investor> getInvestorById(@PathVariable(value = "id") Integer investorId) {
			Investor investor = adminService.findInvestorById(investorId);
			return ResponseEntity.ok(investor);
		}

}
