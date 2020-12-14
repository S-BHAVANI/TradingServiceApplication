package com.cg.tradingservice.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.tradingservice.model.Investor;
import com.cg.tradingservice.model.Stock;


/** The InvestorRepositoryTest class provides testing of InvestorRepository layer
 *   
 * @author Akhil's
 * 
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class InvestorRepositoryTest {
	
	 @Autowired
		private StockRepository stockrep;
		
		@Autowired
		private InvestmentRepository investmentrep;
		
		@Autowired 
		private InvestorRepository investorrep;
	
	  @Autowired
	  private TestEntityManager testEntityManager;
	  
	  @Test
	  public void testGetAllStocks() throws Exception{
			 Stock stock = new Stock();
		        stock.setCompanyName("tcs");
		        stock.setStockOrderType("market");
		        stock.setStockPrice(836);
		        stock.setStockQuantity(4);
		        
		        Stock stock1 = new Stock();
		        stock1.setCompanyName("cts");
		        stock1.setStockOrderType("market");
		        stock1.setStockPrice(500);
		        stock1.setStockQuantity(2);

		        //Save into in memory database
		        testEntityManager.persist(stock);
		        testEntityManager.persist(stock1);

		        //Retrieve all Stocks
		        List<Stock> stockList = (List<Stock>)stockrep.findAll();

		        Assert.assertEquals(2, stockList.size());
		    }
	  
	  @Test
	    public void testbuyStock() throws Exception{
	        Stock stock = getStock();
	        Stock saveInDb = testEntityManager.persist(stock);
	        Stock getFromInDb =stockrep.findById(saveInDb.getCompanyId()).get();
	        assertThat(getFromInDb).isEqualTo(saveInDb);
	    }

		private Stock getStock() {
			// TODO Auto-generated method stub
			Stock stock = new Stock();
	        stock.setCompanyName("bsnl");
	        stock.setStockOrderType("market");
	        stock.setStockPrice(890);
	        stock.setStockQuantity(7);
	        return stock;
			
		}
		
		@Test
	    public void testSellStock() throws Exception{
		 Stock stock = new Stock();
	        stock.setCompanyName("jio");
	        stock.setStockOrderType("market");
	        stock.setStockPrice(400);
	        stock.setStockQuantity(3);
	        

	        Stock stock1 = new Stock();
	        stock1.setCompanyName("idea");
	        stock1.setStockOrderType("market");
	        stock1.setStockPrice(865);
	        stock1.setStockQuantity(4);
	        

	        Stock stock2 = testEntityManager.persist(stock);
	        testEntityManager.persist(stock1);

	        //delete one ticket DB
	        testEntityManager.remove(stock2);

	        List<Stock> stocks = (List<Stock>) stockrep.findAll();
	        Assert.assertEquals(1, stocks.size());

	    }
		
		 @Test
		  public void testgetwatchList() throws Exception{
				 Stock stock = new Stock();
			        stock.setCompanyName("tcs");
			        stock.setStockOrderType("market");
			        stock.setStockPrice(836);
			        stock.setStockQuantity(4);
			        
			        Stock stock1 = new Stock();
			        stock1.setCompanyName("cts");
			        stock1.setStockOrderType("market");
			        stock1.setStockPrice(500);
			        stock1.setStockQuantity(2);

			        //Save into in memory database
			        testEntityManager.persist(stock);
			        testEntityManager.persist(stock1);

			        //Retrieve all tickets
			        List<Stock> stockList = (List<Stock>)stockrep.findAll();

			        Assert.assertEquals(2, stockList.size());
			    }
		
		
}
