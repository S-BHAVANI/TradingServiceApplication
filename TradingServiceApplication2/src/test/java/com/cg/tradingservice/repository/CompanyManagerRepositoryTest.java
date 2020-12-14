package com.cg.tradingservice.repository;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.tradingservice.model.Stock;

/** The CompanyManagerRepositoryTest class provides testing of CompanyManagerRepository layer
 *   
 * @author Kavya's
 * 
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class CompanyManagerRepositoryTest {

	    @Autowired
	    private CompanyManagerRepository companyManagerRepository;

	    @Autowired
	    private TestEntityManager testEntityManager;

	    @Test
	    public void testNewStock() throws Exception{
	        Stock stock = getStock();
	        Stock saveInDb = testEntityManager.persist(stock);
	        Stock getFromInDb = companyManagerRepository.findById(saveInDb.getCompanyId()).get();
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
		    public void testGetStockById() throws Exception{
		        Stock stock = new Stock();
		        stock.setCompanyName("icici");
		        stock.setStockOrderType("market");
		        stock.setStockPrice(786);
		        stock.setStockQuantity(7);

		        //Insert Data into in memory database
		        Stock saveInDb = testEntityManager.persist(stock);
		        //Get Data from DB
		        Stock getInDb = companyManagerRepository.findById(stock.getCompanyId()).get();
		        assertThat(getInDb).isEqualTo(saveInDb);
}
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

		        //Retrieve all tickets
		        List<Stock> stockList = (List<Stock>) companyManagerRepository.findAll();

		        Assert.assertEquals(2, stockList.size());
		    }
		 @Test
		    public void testDeleteStockById() throws Exception{
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

		        List<Stock> stocks = (List<Stock>) companyManagerRepository.findAll();
		        Assert.assertEquals(1, stocks.size());

		    }
		 @Test
		    public void testUpdateStock(){

			 Stock stock = new Stock();
		        stock.setCompanyName("jio");
		        stock.setStockOrderType("market");
		        stock.setStockPrice(400);
		        stock.setStockQuantity(3);
		        
		        testEntityManager.persist(stock);

		        Stock getFromDb = companyManagerRepository.findById(stock.getCompanyId()).get();
		        getFromDb.setStockPrice(500);
		        testEntityManager.persist(getFromDb);

		        assertThat(getFromDb.getStockPrice()).isEqualTo(500);
		    }


}
