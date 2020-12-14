package com.cg.tradingservice.services.impl;
import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tradingservice.exception.ResourceNotFoundException;
import com.cg.tradingservice.model.Investment;
import com.cg.tradingservice.model.Stock;
import com.cg.tradingservice.repository.InvestmentRepository;
import com.cg.tradingservice.repository.InvestorRepository;
import com.cg.tradingservice.repository.StockRepository;
import com.cg.tradingservice.services.InvestorService;


/** The InvestorServiceImpl class provides access to repository CRUD methods for Investment details
 * 
 * 
 * @author Akhil's
 *
 */
@Service
@Transactional
public class InvestorServiceImpl implements InvestorService{

	@Autowired
	private StockRepository stockrep;
	
	@Autowired
	private InvestmentRepository investmentrep;
	
	@Autowired 
	private InvestorRepository investorrep;
	

     public List<Stock> getAllStock(){
	     return stockrep.findAll();
	   
     }
    public List<Investment> getwatchList(int investorId){
        return investmentrep.findByinvestmentInvestorId(investorId);
      }

    public Investment buyStock(Investment investment ) {
	    return investmentrep.save(investment);
      }
    public boolean sellStock(Integer investmentId) {
	   Investment investment = (investmentrep.findById(investmentId)).get();
	    investmentrep.delete(investment);
	   return true;
     }
   
    public Stock getStockById(int companyId) {
    	Stock s = stockrep.findByCompanyId(companyId);
    	return s;
    }
    
}