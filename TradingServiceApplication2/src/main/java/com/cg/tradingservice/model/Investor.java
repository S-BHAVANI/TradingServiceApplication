package com.cg.tradingservice.model;
/** This is an entity class for Investor with getters and setters  and constructor
 * 
 * @author Bhavani's
 * @version 1.0
 *
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/** This is an entity class for Company Manager with getters and setters  and constructor
 * 
 * @author Bhavani's
 * @version 2.0
 *
 */
@Entity 
@Table(name ="INVESTOR")
public class Investor {
	
	@Id
	@Column(name = "investor_id", nullable = false)
	private int investorId;
	
	@Column(name = "investor_name", nullable = false)
	private String investorName;
	
	@Column(name = "investor_pannum", nullable = false)
	private String investorPannum;
	
	@Column(name = "investor_email", nullable = false)
	private String investorEmail;
	
	@Column(name = "investor_phone", nullable = false)
	private String investorPhone;
	
	@Column(name = "no_of_stocks_bought", nullable = false)
	private int numOfStocks;
	
	@Column(name = "total_investment", nullable = false)
	private int investorInvestment;
    
	public Investor() {
		
	}
	
	
	public int getInvestorId() {
		return investorId;
	}

	public void setInvestorId(int investorId) {
		this.investorId = investorId;
	}
	
	
	public String getInvestorName() {
		return investorName;
	}

	public void setInvestorName(String investorName) {
		this.investorName = investorName;
	}
	
	
	public String getInvestorPannum() {
		return investorPannum;
	}

	public void setInvestorPannum(String investorPannum) {
		this.investorPannum = investorPannum;
	}
	

	public String getInvestorEmail() {
		return investorEmail;
	}

	public void setInvestorEmail(String investorEmail) {
		this.investorEmail = investorEmail;
	}
	

	public String getInvestorPhone() {
		return investorPhone;
	}

	public void setInvestorPhone(String investorPhone) {
		this.investorPhone = investorPhone;
	}
	
	public int getNumOfStocks() {
		return numOfStocks;
	}

	public void setNumOfStocks(int numOfStocks) {
		this.numOfStocks = numOfStocks;
	}
	
	public int getInvestorInvestment() {
		return investorInvestment;
	}

	public void setInvestorInvestment(int investorInvestment) {
		this.investorInvestment = investorInvestment;
	}
   

}
