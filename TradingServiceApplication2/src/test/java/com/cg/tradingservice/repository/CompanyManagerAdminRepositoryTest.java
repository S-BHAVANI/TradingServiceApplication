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

import com.cg.tradingservice.model.CompanyManager;
import com.cg.tradingservice.model.Investor;





@RunWith(SpringRunner.class)
@DataJpaTest
public class CompanyManagerAdminRepositoryTest {
	  @Autowired
	    private CompanyManagerAdminRepository companyManagerAdminRepository;
	  
	
	    @Autowired
	    private TestEntityManager testEntityManager;
	    
	    

	    @Test
	    public void testNewCompanyManager() throws Exception{
	    	CompanyManager companymanager=getCompanyManager();
	    	CompanyManager saveInDb=testEntityManager.persist(companymanager);
	    	CompanyManager getFromInDb= companyManagerAdminRepository.findById(saveInDb.getCompanyManagerId()).get();
	    	 assertThat(getFromInDb).isEqualTo(saveInDb);
	    }
	   

	    @Test
	    public void testDeleteCompanyManagerById() throws Exception{
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
	    	
	    	CompanyManager companymanager=testEntityManager.persist(companymanager1);
	    	 testEntityManager.persist(companymanager2);
	    	 
	    	//delete one ticket DB
		     testEntityManager.remove(companymanager);
		        
	    	

		    List<CompanyManager> companymanagers = (List<CompanyManager>)companyManagerAdminRepository.findAll();
		    Assert.assertEquals(companymanagers.size(), 1);      

	    }
 
	    @Test
	    public void testUpdateCompanyManagerById(){

	    	CompanyManager companymanager2=new CompanyManager();
	    	companymanager2.setCompanyManagerId(0);
	    	companymanager2.setCompanyManagerCompanyName("MART");
	    	companymanager2.setCompanyManagerEmail("bhavs@gmail.com");
	    	companymanager2.setCompanyManagerPhone("08512");
	    	
	    	 testEntityManager.persist(companymanager2);
	    	 CompanyManager  getFromDb =companyManagerAdminRepository.findById(0).get();
	    	 getFromDb.setCompanyManagerId(1);
	    	 testEntityManager.persist(getFromDb);
	    	 
	    	 assertThat(getFromDb.getCompanyManagerId()).isEqualTo(1);
	    }

	   
	   
	    @Test
	    public void testGetAllCompanyManagers() throws Exception{
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
	    	
	    	 testEntityManager.persist(companymanager1);
	    	 testEntityManager.persist(companymanager2);
	    	 
	    	 //Retrieve all companymanagers
		     
	    	 List<CompanyManager> companymanagerlist = (List<CompanyManager>)companyManagerAdminRepository.findAll();
		        Assert.assertEquals(2, companymanagerlist.size());
	    }
	    
	   
	    
	    
	 
		private CompanyManager getCompanyManager() {
	    	CompanyManager companymanager=new CompanyManager();
	    	companymanager.setCompanyManagerId(1);
	    	companymanager.setCompanyManagerCompanyName("MART");
	    	companymanager.setCompanyManagerEmail("bhavs@gmail.com");
	    	companymanager.setCompanyManagerPhone("08512");
	        return companymanager;
	    }

	    	
}
