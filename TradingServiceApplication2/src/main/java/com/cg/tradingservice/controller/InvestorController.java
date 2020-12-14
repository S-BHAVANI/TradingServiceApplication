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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tradingservice.exception.ResourceNotFoundException;
import com.cg.tradingservice.model.CompanyManager;
import com.cg.tradingservice.model.Investment;
import com.cg.tradingservice.model.Investor;
import com.cg.tradingservice.model.Stock;
import com.cg.tradingservice.services.InvestorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



/** This is a Controller class for Investor details 
 * 
 * @author Akhil's
 *  @version 2.0
 *
 */
@CrossOrigin(origins = "http://localhost:3000")
@Api(value = "InvestorController", description = "REST Apis related to Investment and Stock Entity!!!!")
@RestController
@RequestMapping("/api/v2")
public class InvestorController {

	@Autowired
	private InvestorService investor;
	
	 private static final Logger logger = LogManager.getLogger(InvestorController.class);
	
	 
	 
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
	
	@GetMapping("/stock")
	public List<Stock> getstock(){
		logger.info("Get all Stock Details");
		return investor.getAllStock();	
	}
	   
	   @ApiOperation(value = "Getting specific  Stock from the System ", response = Stock.class)
		/** This method returns stock details 
		 * 
		 * @param delivery - company Id details
		 * 
		 * 
		 */
		
		
		@GetMapping("/stock/{companyId}")
		@ResponseBody
		public Stock getStockById(@PathVariable("companyId") int companyId){
			logger.info("Getting  Stock Details");
			return investor.getStockById(companyId);
		}
		
	
	 @ApiOperation(value = "Getting specific Watchlist Stock from the System ", response = Investment.class)
	/** This method returns list of all Investment details 
	 * 
	 * @param delivery - Investor Id details
	 * 
	 * 
	 */
	
	
	@GetMapping("/watchlist/{investorId}")
	@ResponseBody
	public List<Investment> getwatchlist(@PathVariable("investorId") int investorId){
		logger.info("Getting Watchlist Stock Details");
		return investor.getwatchList(investorId);
	}
	
	
	@ApiOperation(value = "Adding specific Stock in the Investment ", response = Investment.class)
	/** This method adds the Stock details which needs to buy to the investment table
	 * 
	 * @param delivery - Stock entity details
	 * 
	 * 
	 */
	
	@PostMapping("/stock")
	@ResponseBody
	public Investment buyStock(Investment investment) {
		logger.info("Buying the Stock");
		return investor.buyStock(investment);
		
	}
	
	
	@ApiOperation(value = "Deleting specific Stock from the Investment ", response = Investment.class)
	/** This method deletes the investment details 
	 * 
	 * @param delivery - investment Id details
	 * 
	 * 
	 */
	
	@DeleteMapping("/sell/{investmentId}")
	@ResponseBody
	public boolean sellStock(@PathVariable(value="investmentId") Integer investmentId) {
		logger.info("Selling the Stock");
		investor.sellStock( investmentId);
		return true;
		
	}
	
}
