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
 * @author Kavya's
 * @version 2.0
 *
 */
@Entity
@Table(name="Stock")
public class Stock {
	
	    @ApiModelProperty(notes = "Id of the Company",name="companyId",required=true,value="Company Id")
	    @Id
		@GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name="company_id")
		private Integer companyId;
	    
	    @ApiModelProperty(notes = "Name of the Company",name="companyName",required=true,value="Company Name")
		@Column(name="company_name",nullable = false)
		private String companyName;
		
	    @ApiModelProperty(notes = "Price of the Stock",name="stockPrice",required=true,value="Stock Price")
		@Column(name="stock_price",nullable = false)
		private Integer stockPrice;
		
	    @ApiModelProperty(notes = "Quantity of the Stock",name="stockQuantity",required=true,value="Stock Quantity")
		@Column(name="stock_quantity",nullable = false)
		private Integer stockQuantity;
		
	    @ApiModelProperty(notes = "Order Type of the Stock",name="stockOrderType",required=true,value="Stock Order Type")
		@Column(name="stock_ordertype",nullable = false)
		private String stockOrderType;
		
		public Integer getCompanyId() {
			return companyId;
		}
		public void setCompanyId(Integer companyId) {
			this.companyId = companyId;
		}
		
		public String getCompanyName() {
			return companyName;
		}
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		public Integer getStockPrice() {
			return stockPrice;
		}
		public void setStockPrice(Integer stockPrice) {
			this.stockPrice = stockPrice;
		}
		public Integer getStockQuantity() {
			return stockQuantity;
		}
		public void setStockQuantity(Integer stockQuantity) {
			this.stockQuantity = stockQuantity;
		}
		public String getStockOrderType() {
			return stockOrderType;
		}
		public void setStockOrderType(String stockOrderType) {
			this.stockOrderType = stockOrderType;
		}
		
		public Stock() {
			
		}
		
		


}
