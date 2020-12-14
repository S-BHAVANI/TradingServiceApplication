package com.cg.tradingservice.services.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.tradingservice.model.Investment;
import com.cg.tradingservice.model.Stock;
import com.cg.tradingservice.repository.InvestorRepository;
import com.cg.tradingservice.services.InvestorService;


/** The InvestorServiceTest class provides testing of  InvestorService layer
 *   
 * @author Akhil's
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InvestorServiceImplTest {
	
	@MockBean
	private InvestorRepository investorRepository;
	
	 @Autowired
	 private InvestorService investorService;
	 
	 
	 
	   @Test
	   public void testbuyStock() throws Exception{
		   
		   Investment inv=new Investment();
		   inv.setInvestmentCompanySymbol(1);
		   inv.setInvestmentCompanyName("JIO");
		   inv.setInvestmentAmount(200);
		   inv.setInvestmentId(1);
		   inv.setNoOfStocks(2);
		   inv.setInvestmentInvestorId(1);
		  
		   Mockito.when(investorRepository.save(inv)).thenReturn(inv);
	    	 assertThat(investorService.buyStock(inv)).isNotNull();
		   
	   }
	   
	   
	   @Test
	   public void testSellStock() throws Exception{
		 
		   Investment inv=new Investment();
		   inv.setInvestmentCompanySymbol(1);
		   inv.setInvestmentCompanyName("JIO");
		   inv.setInvestmentAmount(200);
		   inv.setInvestmentId(1);
		   inv.setNoOfStocks(2);
		   inv.setInvestmentInvestorId(1);
		   Assert.assertTrue(investorRepository.findById(1).isEmpty());
		   
	   }
	   
	   @Test
	   public void testgetAllStock() throws Exception{
		   
			  Stock stock = new Stock();
		        stock.setCompanyName("dell");
		        stock.setStockOrderType("market");
		        stock.setStockPrice(600);
		        stock.setStockQuantity(9);

		        Stock stock1 = new Stock();
		        stock1.setCompanyName("lenovo");
		        stock1.setStockOrderType("market");
		        stock1.setStockPrice(806);
		        stock1.setStockQuantity(7);

		        List<Stock> stockList = new ArrayList<>();
		        stockList.add(stock);
		        stockList.add(stock1);
		        assertThat(investorService.getAllStock()).isEmpty();
		   
	   }
	   
	   
	   @Test
	   public void testgetwatchlist() throws Exception{
		   Investment inv=new Investment();
		   inv.setInvestmentCompanySymbol(1);
		   inv.setInvestmentCompanyName("JIO");
		   inv.setInvestmentAmount(200);
		   inv.setInvestmentId(1);
		   inv.setNoOfStocks(2);
		   inv.setInvestmentInvestorId(1);
	    	 Mockito.when(investorRepository.save(inv)).thenReturn(inv);
	         assertThat(investorService.getwatchList(4)).isEmpty();
		   
		   
	   }
	   
	   
}
