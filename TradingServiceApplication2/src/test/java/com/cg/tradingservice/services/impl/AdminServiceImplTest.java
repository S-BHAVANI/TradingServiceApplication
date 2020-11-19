package com.cg.tradingservice.services.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.tradingservice.model.CompanyManager;
import com.cg.tradingservice.model.Investor;
import com.cg.tradingservice.repository.CompanyManagerAdminRepository;
import com.cg.tradingservice.repository.InvestorAdminRepository;
import com.cg.tradingservice.services.AdminService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceImplTest {
	
	@MockBean
    private CompanyManagerAdminRepository companymanageradminRepository;
	
	@MockBean
    private InvestorAdminRepository investoradminRepository;
	
	  @Autowired
	  private AdminService adminService;
	  
	  @Test
	    public void testCreateCompanyManager() throws Exception{
		  CompanyManager companymanager=new CompanyManager();
	    	companymanager.setCompanyManagerId(1);
	    	companymanager.setCompanyManagerCompanyName("MART");
	    	companymanager.setCompanyManagerEmail("bhavs@gmail.com");
	    	companymanager.setCompanyManagerPhone("08512");
	    	 Mockito.when(companymanageradminRepository.save(companymanager)).thenReturn(companymanager);
	    	 assertThat(adminService.createCompanyManager(companymanager)).isEqualTo(companymanager);               
	    }
	  @Test
	  public void testCreateInvestor() throws Exception{
		  Investor investor=new Investor();
	    	investor.setInvestorId(3);
	    	investor.setInvestorName("bhavani");
	    	investor.setInvestorEmail("bhavani@gmail.com");
	    	investor.setInvestorPannum("MOS190");
	    	investor.setInvestorPhone("9550355319");
	    	 Mockito.when(investoradminRepository.save(investor)).thenReturn(investor);
	    	 assertThat(adminService.createInvestor(investor)).isEqualTo(investor);
	  }
	  
	  
	  @Test
	    public void testGetAllInvestors() throws Exception{
	    	Investor investor1=new Investor();
	    	investor1.setInvestorId(1);
	    	investor1.setInvestorName("bhavani");
	    	investor1.setInvestorEmail("bhavani@gmail.com");
	    	investor1.setInvestorPannum("MOS190");
	    	investor1.setInvestorPhone("9550355319");

	    	Investor investor2=new Investor();
	    	investor2.setInvestorId(2);
	    	investor2.setInvestorName("akhil");
	    	investor2.setInvestorEmail("akhil@gmail.com");
	    	investor2.setInvestorPannum("MOS196");
	    	investor2.setInvestorPhone("9701531212");


	        List<Investor> investorlist = new ArrayList<>();
	        investorlist.add(investor1);                             
	        investorlist.add(investor2);                     
	        
	        Mockito.when(investoradminRepository.findAll()).thenReturn(investorlist);  
	        assertThat(adminService.getAllInvestor()).isEqualTo(investorlist);
	    }
	       
	  
	  @Test
	    public void testGetAllCompanyManager() throws Exception{
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
	    	

	        List<CompanyManager> companymanagerlist = new ArrayList<>();
	        companymanagerlist.add(companymanager1);
	        companymanagerlist.add(companymanager2);
	        
	        Mockito.when(companymanageradminRepository.findAll()).thenReturn(companymanagerlist);  
	        assertThat(adminService.getAllCompanyManager()).isEqualTo(companymanagerlist);
	    	
	  }  
	  @Test
	    public void testDeleteInvestorById() throws Exception{
		  
		  Investor investor=new Investor();
	    	investor.setInvestorId(2);
	    	investor.setInvestorName("bhavani");
	    	investor.setInvestorEmail("bhavani@gmail.com");
	    	investor.setInvestorPannum("MOS190");
	    	investor.setInvestorPhone("9550355319");
	    	 investoradminRepository.deleteById(investor.getInvestorId());
	    	 System.out.println(investoradminRepository.findById(2));
	    	 Assert.assertTrue(investoradminRepository.findById(2).isEmpty());                
	    }
	  @Test
	    public void testDeleteCompanyManagerById() throws Exception{
		  CompanyManager companymanager=new CompanyManager();
	    	companymanager.setCompanyManagerId(1);
	    	companymanager.setCompanyManagerCompanyName("MART");
	    	companymanager.setCompanyManagerEmail("bhavs@gmail.com");
	    	companymanager.setCompanyManagerPhone("08512");
	    	companymanageradminRepository.deleteById(companymanager.getCompanyManagerId());
	    	System.out.println(companymanageradminRepository.findById(1));
	    	 Assert.assertTrue(companymanageradminRepository.findById(1).isEmpty());    
	  }  
	  
	
	  @Test
	    public void testFindByEmail() throws Exception{
		  Investor investor2=new Investor();
	    	investor2.setInvestorId(6);
	    	investor2.setInvestorName("bhavani");
	    	investor2.setInvestorEmail("bhavani@gmail.com");
	    	investor2.setInvestorPannum("MOS190");
	    	investor2.setInvestorPhone("9550355319");
	    	
	    	 Mockito.when(investoradminRepository.findByEmail("bhavani@gmail.com")).thenReturn(investor2);
	    	 assertThat(adminService.findInvestorByEmail("bhavani@gmail.com")).isEqualTo(investor2);
	    }
	  
	  @Test
		public void testUpdateInvestorById() throws Exception{
			Investor investor2=new Investor();
	    	investor2.setInvestorId(6);
	    	investor2.setInvestorName("bhavani");
	    	investor2.setInvestorEmail("bhavani@gmail.com");
	    	investor2.setInvestorPannum("MOS190");
	    	investor2.setInvestorPhone("9550355319");
	    	
	    	  Mockito.when(investoradminRepository.save(investor2)).thenReturn(investor2);
	    	  Mockito.when(investoradminRepository.findByEmail("bhavani@gmail.com")).thenReturn(investor2);                       //findById(6).get()).thenReturn(investor2);
	    	  investor2.setInvestorEmail("bhavs@gmail.com");
	    	  System.out.println(investor2.getInvestorEmail());
	    	  Mockito.when(investoradminRepository.save(investor2)).thenReturn(investor2);
	    	  System.out.println(investor2.getInvestorEmail());
	    	  
	    	  assertThat(adminService.findInvestorByEmail("bhavs@gmail.com")).isEqualTo(investor2.getInvestorEmail());
	    	//  assertThat(adminService.updateInvestorEmailbyId(6,"bhavs@gmail.com")).isEqualTo(investor2);
	  
	 
		}


	@Test
	public void testUpdateCompanyManagerById() throws Exception{
		CompanyManager companymanager=new CompanyManager();
    	companymanager.setCompanyManagerId(1);
    	companymanager.setCompanyManagerCompanyName("MART");
    	companymanager.setCompanyManagerEmail("bhavs@gmail.com");
    	companymanager.setCompanyManagerPhone("08512");
    	
    	System.out.println( Mockito.when(companymanageradminRepository.save(companymanager)).thenReturn(companymanager));
    	  companymanager.setCompanyManagerEmail("bhavani@gmail.com");
    	  
     	 System.out.println(companymanager.getCompanyManagerEmail());
     	 System.out.println( Mockito.when(companymanageradminRepository.findById(3).get()).thenReturn(companymanager));
     	 //assertThat(adminService.updateCompanyManager(1,"bhavani@gmail.com"))
	}  
	
	  
	
	  
	 
}
