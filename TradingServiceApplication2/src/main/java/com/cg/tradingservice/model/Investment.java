package com.cg.tradingservice.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

/** This is an entity class for Company Manager with getters and setters  and constructor
 * 
 * @author Akhil's
 * @version 2.0
 *
 */
@Entity
@Table(name ="INVESTMENT")
public class Investment {
	
	@ApiModelProperty(notes = "Id of the Investment",name="investmentId",required=true,value="Investment Id")
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "INVESTMENT_ID")
	private int investmentId;
    
	@ApiModelProperty(notes = "Investment Company Symbol",name="investmentCompanySymbol",required=true,value="Investment Company Symbol")
	@Column(name ="INVESTMENT_COMPANY_SYMBOL")
	private int investmentCompanySymbol;
	
	@ApiModelProperty(notes = "Company Name of Investment",name="investmentCompanyName",required=true,value="Investment Company Name")
	@Column(name ="INVESTMENT_COMPANY_NAME")
	private String investmentCompanyName;
	
	@ApiModelProperty(notes = "Amount of the Investment",name="investmentAmount",required=true,value="Investment Amount")
	@Column(name ="INVESTMENT_AMOUNT")
	private int investmentAmount;
	
	@ApiModelProperty(notes = "Id of the investor Investment",name="investmentInvestorId",required=true,value="Investment Investor Id")
	@Column(name ="INVESTMENT_INVESTOR_ID")
	private int investmentInvestorId;
	
	@ApiModelProperty(notes = "No Of Stocks",name="noOfStocks",required=true,value="No Of Stocks")
	@Column(name ="NO_OF_STOCKS")
	private int noOfStocks;
	
	public Investment() {
		
	}
	
	public int getInvestmentId() {
		return investmentId;
	}
	public void setInvestmentId(int investmentId) {
		this.investmentId = investmentId;
	}
	public int getInvestmentCompanySymbol() {
		return investmentCompanySymbol;
	}
	public void setInvestmentCompanySymbol(int investmentCompanySymbol) {
		this.investmentCompanySymbol = investmentCompanySymbol;
	}
	public String getInvestmentCompanyName() {
		return investmentCompanyName;
	}
	public void setInvestmentCompanyName(String investmentCompanyName) {
		this.investmentCompanyName = investmentCompanyName;
	}
	public int getInvestmentAmount() {
		return investmentAmount;
	}
	public void setInvestmentAmount(int investmentAmount) {
		this.investmentAmount = investmentAmount;
	}
	public int getInvestmentInvestorId() {
		return investmentInvestorId;
	}
	public void setInvestmentInvestorId(int investmentInvestorId) {
		this.investmentInvestorId = investmentInvestorId;
	}
	public int getNoOfStocks() {
		return noOfStocks;
	}
	public void setNoOfStocks(int noOfStocks) {
		this.noOfStocks = noOfStocks;
	}
	
	
}
