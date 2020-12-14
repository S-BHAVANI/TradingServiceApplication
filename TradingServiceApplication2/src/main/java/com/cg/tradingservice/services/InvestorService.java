package com.cg.tradingservice.services;

import java.util.List;

import com.cg.tradingservice.exception.ResourceNotFoundException;
import com.cg.tradingservice.model.Investment;
import com.cg.tradingservice.model.Stock;


/** This is an Service interface which defines CRUD methods for Investment and Stock details
 * 
 * @author Akhil's
 *
 */
public interface InvestorService {

	List<Stock> getAllStock();

	List<Investment> getwatchList(int investorId);

	Investment buyStock(Investment investment);

	boolean sellStock(Integer investmentId);
	
	 

	Stock getStockById(int companyId);

	

}
