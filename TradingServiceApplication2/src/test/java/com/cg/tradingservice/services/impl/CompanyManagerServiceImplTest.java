package com.cg.tradingservice.services.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.tradingservice.model.Stock;
import com.cg.tradingservice.repository.CompanyManagerRepository;

import junit.framework.Assert;


/** The CompanyManagerServiceTest class provides testing of  CompanyManagerService layer
 *   
 * @author Kavya's
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyManagerServiceImplTest {

	 @MockBean
	    private CompanyManagerRepository companyManagerRepository;

	    @Autowired
	    private CompanyManagerServiceImpl companyManagerService;
       
	    
	       
	@Test
     public void testGetAllStock() throws Exception{
		Stock stock = new Stock();
        stock.setCompanyName("samsung");
        stock.setStockOrderType("market");
        stock.setStockPrice(600);
        stock.setStockQuantity(9);

        Stock stock1 = new Stock();
        stock1.setCompanyName("hp");
        stock1.setStockOrderType("market");
        stock1.setStockPrice(600);
        stock1.setStockQuantity(9);

        List<Stock> stockList = new ArrayList<>();
        stockList.add(stock);
        stockList.add(stock1);

        Mockito.when(companyManagerRepository.findAll()).thenReturn(stockList);
        assertThat(companyManagerService.getAllStock()).isEqualTo(stockList);

}

	@Test
	public void testCreateStock() throws Exception{
		Stock stock = new Stock();
		stock.setCompanyId(40);
        stock.setCompanyName("Lg");
        stock.setStockOrderType("market");
        stock.setStockPrice(600);
        stock.setStockQuantity(9);

        Mockito.when(companyManagerRepository.save(stock)).thenReturn(stock);
        assertThat(companyManagerService.createStock(stock)).isEqualTo(stock);
    }
		

	@Test
	public void testGetStockById() throws Exception {
		Stock stock = new Stock();
		stock.setCompanyId(501);
        stock.setCompanyName("acer");
        stock.setStockOrderType("market");
        stock.setStockPrice(600);
        stock.setStockQuantity(9);
        Mockito.when(companyManagerRepository.save(stock)).thenReturn(stock);
        Assert.assertTrue(companyManagerRepository.findById(502).isEmpty());    
		 
    }
		

	@Test
	public void testUpdateStock() throws Exception {

		Stock stock = new Stock();
		stock.setCompanyId(50);
        stock.setCompanyName("acer");
        stock.setStockOrderType("market");
        stock.setStockPrice(600);
        stock.setStockQuantity(9);

        Mockito.when(companyManagerRepository.save(stock)).thenReturn(stock);
        Assert.assertTrue(companyManagerRepository.findById(50).isEmpty());  

		    }

	@Test
	public void testDeleteStock() throws Exception {
		Stock stock = new Stock();
		stock.setCompanyId(105);
        stock.setCompanyName("hcl");
        stock.setStockOrderType("market");
        stock.setStockPrice(600);
        stock.setStockQuantity(9);
        companyManagerRepository.deleteById(stock.getCompanyId());
        System.out.println(companyManagerRepository.findById(105));
        Assert.assertTrue(companyManagerRepository.findById(105).isEmpty());
    }
		

}
