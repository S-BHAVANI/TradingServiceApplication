package com.cg.tradingservice.services;
import java.util.List;
import com.cg.tradingservice.exception.ResourceNotFoundException;
import com.cg.tradingservice.model.Stock;


/** This is an Service interface which defines CRUD methods for Stock details
 * 
 * @author Kavya's
 *
 */
public interface CompanyManagerService {
	public List<Stock> getAllStock();
	public Stock createStock(Stock stock);
	 public Stock getStockById(Integer companyId) throws ResourceNotFoundException;
	 public Stock updateStock(Integer companyId, Stock stockDetails) throws ResourceNotFoundException;
	 public boolean deleteStock(Integer companyId) throws ResourceNotFoundException;

}


