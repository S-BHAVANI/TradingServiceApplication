package com.cg.tradingservice.controller;
import java.util.List;

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
import com.cg.tradingservice.model.Investment;
import com.cg.tradingservice.model.Stock;
import com.cg.tradingservice.services.impl.CompanyManagerServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



/** This is a Controller class for Company Manager details 
 * 
 * @author Kavya's
 *  @version 2.0
 *
 */
@CrossOrigin(origins = "http://localhost:3000")
@Api(value = "CompanyManagerController", description = "REST Apis related to Stock Entity!!!!")
@RestController
@RequestMapping("/api/v2")
public class CompanyManagerController {

	
	   private static final Logger logger = LogManager.getLogger(CompanyManagerController.class);
	
	   
		@Autowired
		private CompanyManagerServiceImpl companyManagerService;

		
		
		@ApiOperation(value = "Get list of Stocks from the System ", response = Iterable.class)
		@ApiResponses(value = { 
				@ApiResponse(code = 200, message = "Suceess|OK"),
				@ApiResponse(code = 401, message = "not authorized!"), 
				@ApiResponse(code = 403, message = "forbidden!!!"),
				@ApiResponse(code = 404, message = "not found!!!") })
		
		/** This method returns list of all Stock details 
		 * 
		 * @return list of all Stock details
		 * 
		 * 
		 */
		
		@GetMapping("/Stock")
		public List<Stock> getAllStock() {
			logger.info("Getting All Stock Details");
			return companyManagerService.getAllStock();
		}
		
		
		@ApiOperation(value = "Adding a specific Stock to the System ", response = Stock.class)
		/** This method adds the Stock details 
		 * 
		 * @param delivery - Stock entity details
		 * 
		 * 
		 */
		
		@PostMapping("/CreateStock")
		public Stock createStock( @RequestBody Stock stock) {
			logger.info("Creating a Stock");
			return companyManagerService.createStock(stock);
		} 
		

		 @ApiOperation(value = "Getting a specific Stock from the System ", response = Stock.class)
		/** This method returns one Stock details 
		 * 
		 * 
		 *  @param delivery - Stock Id details
		 * 
		 */
		
		@GetMapping("/Stock/{id}")
		public ResponseEntity<Stock> getStockById(@PathVariable(value = "id") Integer companyId) throws ResourceNotFoundException { 
			logger.info("Getting a Stock By Id");
			Stock stock = companyManagerService.getStockById(companyId);
			return  ResponseEntity.ok(stock);
		}
		
		
		 @ApiOperation(value = "Updating a specific Stock in the System ", response = Stock.class)
		/** This method changes the Investor details 
		 * 
		 * @param delivery - Investor entity details
		 * 
		 * 
		 */
		
		
		@PutMapping("/Stock/{id}")
		public Stock updateStock(@PathVariable(value = "id") Integer companyId,
				 @RequestBody Stock stockDetails) throws ResourceNotFoundException {
			logger.info("Updating Stock Details By Stock Id");
			return companyManagerService.updateStock(companyId, stockDetails);
			
		
		} 

		 @ApiOperation(value = "Deleting a specific Stock from the System ", response = Stock.class)
		/** This method deletes the Stock details 
		 * 
		 * @param delivery - Stock Id details
		 * 
		 * 
		 */
		
		 @DeleteMapping("/Stock/{companyId}")
			public boolean deleteStock(@PathVariable Integer companyId) throws ResourceNotFoundException {
				return companyManagerService.deleteStock(companyId);
		}
		
		 


}
