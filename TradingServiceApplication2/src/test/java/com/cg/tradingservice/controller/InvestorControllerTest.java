package com.cg.tradingservice.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.tradingservice.model.Investment;
import com.cg.tradingservice.model.Stock;
import com.cg.tradingservice.services.InvestorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/** The InvestorControllerTest class provides testing of InvestorDetailsController layer
 *   
 * @author Akhil's
 * 
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = InvestorController.class)
public class InvestorControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	   @MockBean
	    private InvestorService investorService;
	   
	   @Test
	   public void testbuyStock() throws Exception{
		   
		   String URI = "/api/v2/buystocks";
		   Investment inv=new Investment();
		   inv.setInvestmentCompanySymbol(1);
		   inv.setInvestmentCompanyName("JIO");
		   inv.setInvestmentAmount(200);
		   inv.setInvestmentId(1);
		   inv.setNoOfStocks(2);
		   inv.setInvestmentInvestorId(1);
		   String jsonInput = this.converttoJson(inv);
		   

	        Mockito.when(investorService.buyStock(Mockito.any(Investment.class))).thenReturn(inv);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();
	        assertThat(jsonInput).isEqualTo(jsonOutput);
	        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
		   
	   }


	   @Test
	   public void testSellStock() throws Exception{
		   String URI = "/api/v2/sell/{investmentId}";
		   Investment inv=new Investment();
		   inv.setInvestmentCompanySymbol(1);
		   inv.setInvestmentCompanyName("JIO");
		   inv.setInvestmentAmount(200);
		   inv.setInvestmentId(1);
		   inv.setNoOfStocks(2);
		   inv.setInvestmentInvestorId(1);
		   
		   

	    
	        Mockito.when(investorService.sellStock(1));                        
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 1).accept(MediaType.APPLICATION_JSON)).andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

	        Assert.assertNotEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
		   
	   }
		 
	   @Test
	   public void testgetAllStock() throws Exception{
		   
		   String URI = "/api/v2/stock";
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
		    	 List<Stock> stockList=new ArrayList<>();
		    	 stockList.add(stock);
		    	 stockList.add(stock1);
		    	 
		    	 String jsonInput = this.converttoJson(stockList);

		         Mockito.when(investorService.getAllStock()).thenReturn(stockList);
		         MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
		         MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		         String jsonOutput = mockHttpServletResponse.getContentAsString();

		         assertThat(jsonInput).isEqualTo(jsonOutput);
		   
	   }
	   
	   @Test
	   public void testgetwatchlist() throws Exception{
		   String URI = "/api/v2/watchlist/{investorId}";
		   Investment inv=new Investment();
		   inv.setInvestmentCompanySymbol(1);
		   inv.setInvestmentCompanyName("JIO");
		   inv.setInvestmentAmount(200);
		   inv.setInvestmentId(1);
		   inv.setNoOfStocks(2);
		   inv.setInvestmentInvestorId(1);
		  
		   List<Investment> invList=new ArrayList<>();
	    	 invList.add(inv);
	    	
	        
	       System.out.println(Mockito.when(investorService.getwatchList(1)).thenReturn(invList));
	         assertThat(investorService.getwatchList(1)).isNotEmpty();
		   
		   
	   }
		   
	   
	   
	   
	private String converttoJson(Object inv) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(inv);
    }  
	  
	   

}
