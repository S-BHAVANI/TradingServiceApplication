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
 * @author Bhavani's
 * @version 2.0
 *
 */
@Entity
@Table(name ="COMPANY_MANAGER")
public class CompanyManager {
	
	@ApiModelProperty(notes = "Id of the Company Manager",name="companyManagerId",required=true,value="Company Manager Id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "company_manager_id", nullable = false)
	private int companyManagerId;	
	
	@ApiModelProperty(notes = "Name of the Company Manager Company Name",name="companyManagerCompanyName",required=true,value="Company Manager Company Name")
	@Column(name = "company_manager_companyname", nullable = false)
	private String companyManagerCompanyName;
	
	@ApiModelProperty(notes = "Email of the Company Manager",name="companyManagerEmail",required=true,value="Company Manager Email")
	@Column(name = "company_manager_email", nullable = false)
	private String companyManagerEmail;
	
	@ApiModelProperty(notes = "Phone Number of the Company Manager",name="companyManagerPhone",required=true,value="Company Manager Phone Number")
	@Column(name = "company_manager_phone", nullable = false)
	private String companyManagerPhone;
    
	public CompanyManager()
	{
		
	}

	
	public int getCompanyManagerId() {
		return companyManagerId;
	}

	public void setCompanyManagerId(int companyManagerId) {
		this.companyManagerId = companyManagerId;
	}
	
	public String getCompanyManagerCompanyName() {
		return companyManagerCompanyName;
	}

	public void setCompanyManagerCompanyName(String companyManagerCompanyName) {
		this.companyManagerCompanyName = companyManagerCompanyName;
	}
	
	public String getCompanyManagerEmail() {
		return companyManagerEmail;
	
	}

	public void setCompanyManagerEmail(String companyManagerEmail) {
		this.companyManagerEmail = companyManagerEmail;
	}
	
	public String getCompanyManagerPhone() {
		return companyManagerPhone;
	}

	public void setCompanyManagerPhone(String companyManagerPhone) {
		this.companyManagerPhone = companyManagerPhone;
	}

		

}