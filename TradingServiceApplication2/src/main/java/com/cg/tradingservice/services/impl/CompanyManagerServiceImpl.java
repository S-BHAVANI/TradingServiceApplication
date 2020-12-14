package com.cg.tradingservice.services.impl;

import java.util.List;


import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cg.tradingservice.controller.AdminController;
import com.cg.tradingservice.exception.ResourceNotFoundException;
import com.cg.tradingservice.model.Stock;
import com.cg.tradingservice.repository.CompanyManagerRepository;
import com.cg.tradingservice.services.CompanyManagerService;


/** The CompanyManagerServiceImpl class provides access to repository CRUD methods for Stock details
 * 
 * 
 * @author Kavya's
 *
 */
@Service
@Transactional
public class CompanyManagerServiceImpl  implements CompanyManagerService{
	
  String s="Stock not found for this id :: ";
  
  private static final Logger logger = LogManager.getLogger(CompanyManagerServiceImpl.class);
  
  @Autowired
  private CompanyManagerRepository companyManagerRepository;
  
  public List<Stock> getAllStock() {
		return companyManagerRepository.findAll();
	}
  public Stock createStock(Stock stock) {
		return  companyManagerRepository.save(stock);
		
	}
  public Stock getStockById(Integer companyId)
			throws ResourceNotFoundException {
	  return companyManagerRepository.findById(companyId)
				.orElseThrow(() -> new ResourceNotFoundException(s + companyId));
	
}
  public Stock updateStock(Integer companyId, Stock stockDetails) throws ResourceNotFoundException {
	  Stock stock =  companyManagerRepository.findById(companyId)  
				.orElseThrow(() -> new ResourceNotFoundException(s + companyId));
	  stock.setCompanyId(stockDetails.getCompanyId());
	  stock.setCompanyName(stockDetails.getCompanyName());
	  stock.setStockPrice(stockDetails.getStockPrice());
	  stock.setStockQuantity(stockDetails.getStockQuantity());
	  stock.setStockOrderType(stockDetails.getStockOrderType());
		  return companyManagerRepository.save(stock);
		
	
	}
  

  @Override
  public boolean deleteStock(Integer companyId) throws ResourceNotFoundException {
  	companyManagerRepository.deleteById(companyId);
  	return false;
  }
}
