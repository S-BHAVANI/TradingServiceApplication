package com.cg.tradingservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/** This is an entity class for Company Manager with getters and setters  and constructor
 * 
 * @author Bhavani's
 * @version 1.0
 *
 */
@Entity
@Table(name ="COMPANY_MANAGER")
public class CompanyManager {
	
	@Id
	@Column(name = "company_manager_id", nullable = false)
	private int companyManagerId;	
	
	@Column(name = "company_manager_companyname", nullable = false)
	private String companyManagerCompanyName;
	
	@Column(name = "company_manager_email", nullable = false)
	private String companyManagerEmail;
	
	@Column(name = "company_manager_phone", nullable = false)
	private String companyManagerPhone;
    
	public CompanyManager()
	{
		
	}

	public CompanyManager(int companyManagerId, String companyManagerCompanyName, String companyManagerEmail,
			String companyManagerPhone) {
		super();
		this.companyManagerId = companyManagerId;
		this.companyManagerCompanyName = companyManagerCompanyName;
		this.companyManagerEmail = companyManagerEmail;
		this.companyManagerPhone = companyManagerPhone;
	}

	@Override
	public String toString() {
		return "CompanyManager [companyManagerId=" + companyManagerId + ", companyManagerCompanyName="
				+ companyManagerCompanyName + ", companyManagerEmail=" + companyManagerEmail + ", companyManagerPhone="
				+ companyManagerPhone + "]";
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