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

@RunWith(SpringRunner.class)
@DataJpaTest
public class InvestorAdminRepositoryTest {
	
	 @Autowired
	    private InvestorAdminRepository investorAdminRepository;
	 
	 @Autowired
	    private TestEntityManager testEntityManager;
	 
	 @Test
	    public void testNewInvestor() throws Exception{
	    	Investor investor=getInvestor();
	    	Investor saveInDb=testEntityManager.persist(investor);
	    	Investor getFromInDb= investorAdminRepository.findById(saveInDb.getInvestorId()).get();
	    	 assertThat(getFromInDb).isEqualTo(saveInDb);
	    }
	 
	 @Test
     public void testDeleteInvestorById() throws Exception{
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

 	Investor investor=testEntityManager.persist(investor1);
 	 testEntityManager.persist(investor2);
 	 
 	//delete one ticket DB
	     testEntityManager.remove(investor);
	        

	    List<Investor> investors = (List<Investor>)investorAdminRepository.findAll();
	    Assert.assertEquals(investors.size(), 1);      

 }  
	 @Test
	    public void testUpdateInvestorById(){

	    	Investor investor2=new Investor();
	    	investor2.setInvestorId(1);
	    	investor2.setInvestorName("bhavani");
	    	investor2.setInvestorEmail("bhavani@gmail.com");
	    	investor2.setInvestorPannum("MOS190");
	    	investor2.setInvestorPhone("9550355319");

	    	
	    	 testEntityManager.persist(investor2);
	    	 Investor  getFromDb =investorAdminRepository.findById(1).get();
	    	 getFromDb.setInvestorId(2);
	    	 testEntityManager.persist(getFromDb);
	    	 
	    	 assertThat(getFromDb.getInvestorId()).isEqualTo(2);
	    }
	 @Test
	    public void testGetAllInvestors() throws Exception{
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

	        //Save into in memory database
	        testEntityManager.persist(investor1);
	        testEntityManager.persist(investor2);

	        //Retrieve all investors
	     
	        List<Investor> investorlist = (List<Investor>)investorAdminRepository.findAll();
	        Assert.assertEquals(2, investorlist.size());
	    }
  
	 private Investor getInvestor() {
	    	Investor investor=new Investor();
	    	investor.setInvestorId(3);
	    	investor.setInvestorName("bhavani");
	    	investor.setInvestorEmail("bhavani@gmail.com");
	    	investor.setInvestorPannum("MOS190");
	    	investor.setInvestorPhone("9550355319");
			return investor;
		}
}
