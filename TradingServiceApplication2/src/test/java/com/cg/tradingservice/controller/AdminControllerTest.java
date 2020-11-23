package com.cg.tradingservice.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.IntPredicate;

import org.assertj.core.api.AbstractComparableAssert;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.tradingservice.exception.ResourceNotFoundException;
import com.cg.tradingservice.model.CompanyManager;
import com.cg.tradingservice.model.Investor;
import com.cg.tradingservice.services.AdminService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;







/** The AdminControllerTest class provides testing of AdminDetailsController layer
 *   
 * @author Bhavani's
 * 
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = AdminController.class)
public class AdminControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
    private AdminService adminService;
	
	
	 @Test
	   public void testCreateCompanyManager() throws Exception{
		  String URI = "/api/v2/CreateCompanyManager";
		  CompanyManager companymanager=new CompanyManager();
		  companymanager.setCompanyManagerId(3);
		  companymanager.setCompanyManagerCompanyName("MART");
		  companymanager.setCompanyManagerEmail("chiku@gmail.com");
		  companymanager.setCompanyManagerPhone("08512518301");
		  String jsonInput = this.converttoJson(companymanager);

		  Mockito.when(adminService.createCompanyManager(Mockito.any(CompanyManager.class))).thenReturn(companymanager);
		  MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
		  MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();
	        assertThat(jsonInput).isEqualTo(jsonOutput);
	        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	 }
	 
	 
	 @Test
	   public void testCreateInvestor() throws Exception{
		  String URI = "/api/v2/CreateInvestor";
		  Investor investor=new Investor();
		  investor.setInvestorId(4);
		  investor.setInvestorName("akhil");
		  investor.setInvestorPannum("MOS196");
		  investor.setInvestorPhone("9701531212");
		  investor.setInvestorEmail("kavya@gmail.com");
		  String jsonInput = this.converttoJson(investor);

		  Mockito.when(adminService.createInvestor(Mockito.any(Investor.class))).thenReturn(investor);
		  MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
		  MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();
	        assertThat(jsonInput).isEqualTo(jsonOutput);
	        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	 
	 }  
	 @Test
	 public void testDeleteCompanyManager() throws Exception{
		 String URI = "/api/v2/CompanyManager/{id}";
		  CompanyManager companymanager=new CompanyManager();
	    	companymanager.setCompanyManagerId(1);
	    	companymanager.setCompanyManagerCompanyName("MART");
	    	companymanager.setCompanyManagerEmail("bhavs@gmail.com");
	    	companymanager.setCompanyManagerPhone("08512");
	    	
	    	adminService.deleteCompanyManager(companymanager.getCompanyManagerId());
	    	
	    assertThat(adminService.deleteCompanyManager(1)).isFalse();
	    	
	    	
	  } 
	 @Test
	 public void testDeleteInvestorById() throws Exception{
		 String URI = "/api/v2/Investor/{id}";
		 Investor investor=new Investor();
	    	investor.setInvestorId(3);
	    	investor.setInvestorName("bhavani");
	    	investor.setInvestorEmail("bhavani@gmail.com");
	    	investor.setInvestorPannum("MOS190");
	    	investor.setInvestorPhone("9550355319");
	    	adminService.deleteCompanyManager(investor.getInvestorId());
	    	assertThat(adminService.deleteInvestorById(3)).isFalse();
	  }

	    @Test
	    public void testUpdateInvestorById() throws Exception{
	    	
	     String URI= "/api/v2/Investor/{id}";
	     Investor investor=new Investor();
	    	investor.setInvestorId(3);
	    	investor.setInvestorName("bhavani");
	    	investor.setInvestorEmail("bhavani@gmail.com");
	    	investor.setInvestorPannum("MOS190");
	    	investor.setInvestorPhone("9550355319");
	    	 String jsonInput = this.converttoJson(investor);
	    	 
	    	Mockito.when(adminService.updateInvestorById(Mockito.any(), Mockito.any())).thenReturn(investor);
	    	 MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI, 3).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                 .andReturn();
	         MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	         String jsonOutput = mockHttpServletResponse.getContentAsString();

	         assertThat(jsonInput).isEqualTo(jsonOutput);

	    }
	  
	    @Test
	    public void testUpdateCompanyManagerById() throws Exception{
	    	 String URI= "/api/v2/CompanyManager/{id}";
	    	 CompanyManager companymanager=new CompanyManager();
		    	companymanager.setCompanyManagerId(1);
		    	companymanager.setCompanyManagerCompanyName("MART");
		    	companymanager.setCompanyManagerEmail("bhavs@gmail.com");
		    	companymanager.setCompanyManagerPhone("08512");
		    	 String jsonInput = this.converttoJson(companymanager);
		    		Mockito.when(adminService.updateCompanyManager(Mockito.any(), Mockito.any())).thenReturn(companymanager);
			    	 MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI, 3).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
			                 .andReturn();
			         MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
			         String jsonOutput = mockHttpServletResponse.getContentAsString();

			         assertThat(jsonInput).isEqualTo(jsonOutput);  	 
	    }
	    

	    @Test
	    public void testGetAllCompanyManagers() throws Exception{
	    	
	       String URI= "/api/v2/CompanyManager";
	    	CompanyManager companymanager1=new CompanyManager();
	    	companymanager1.setCompanyManagerId(1);
	    	companymanager1.setCompanyManagerCompanyName("MART");
	    	companymanager1.setCompanyManagerEmail("bhavs@gmail.com");
	    	companymanager1.setCompanyManagerPhone("08512");
	    	
	    	CompanyManager companymanager2=new CompanyManager();
	    	companymanager2.setCompanyManagerId(0);
	    	companymanager2.setCompanyManagerCompanyName("MART");
	    	companymanager2.setCompanyManagerEmail("bhavs@gmail.com");
	    	companymanager2.setCompanyManagerPhone("08512");
	    	
	    	List<CompanyManager> companymanagerlist=new ArrayList<>();
	    	companymanagerlist.add(companymanager1);
	    	companymanagerlist.add(companymanager2);
	    	
	    	String jsonInput = this.converttoJson(companymanagerlist);
	    	Mockito.when(adminService.getAllCompanyManager()).thenReturn(companymanagerlist);
	    	MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();

	        assertThat(jsonInput).isEqualTo(jsonOutput);
	  
	    }
	  
	    @Test
	    public void testGetAllInvestors() throws Exception{
	    	
	    	String URI= "/api/v2/Investor";
	    	Investor investor1=new Investor();
	    	investor1.setInvestorId(3);
	    	investor1.setInvestorName("bhavani");
	    	investor1.setInvestorEmail("bhavani@gmail.com");
	    	investor1.setInvestorPannum("MOS190");
	    	investor1.setInvestorPhone("9550355319");

	    	Investor investor2=new Investor();
	    	investor2.setInvestorId(1);
	    	investor2.setInvestorName("bhavani");
	    	investor2.setInvestorEmail("bhavani@gmail.com");
	    	investor2.setInvestorPannum("MOS190");
	    	investor2.setInvestorPhone("9550355319");

	       List<Investor> investorlist=new ArrayList<>();
	       investorlist.add(investor1);
	       investorlist.add(investor2);
	       String jsonInput = this.converttoJson(investorlist);
	       
	       Mockito.when(adminService.getAllInvestor()).thenReturn(investorlist);
	       MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();

	        assertThat(jsonInput).isEqualTo(jsonOutput);
	  
	    }

	  /**
     * Convert Object into Json String by using Jackson ObjectMapper
     * @param ticket
     * @return
     * @throws JsonProcessingException
     */
    private String converttoJson(Object companymanager) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(companymanager);
    }

}
