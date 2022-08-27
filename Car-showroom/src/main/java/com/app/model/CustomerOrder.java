package com.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CustomerOrder {
	@Id
	@GeneratedValue (strategy =  GenerationType.AUTO)
	private int count; 
	private int orderid;
	private String fueltype;
	private String colourName;
	private String ModelName;
	private String customerName;
	private double price;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getFueltype() {
		return fueltype;
	}
	public void setFueltype(String fueltype) {
		this.fueltype = fueltype;
	}
	public String getColourName() {
		return colourName;
	}
	public void setColourName(String colourName) {
		this.colourName = colourName;
	}
	public String getModelName() {
		return ModelName;
	}
	public void setModelName(String modelName) {
		ModelName = modelName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public CustomerOrder() {
		super();
		this.orderid = orderid;
		this.fueltype = fueltype;
		this.colourName = colourName;
		ModelName = getModelName();
		this.customerName = customerName;
		this.price = price;
	}
	@Override
	public String toString() {
		return "CustomerOrder [orderid=" + orderid + ", fueltype=" + fueltype + ", colourName=" + colourName
				+ ", ModelName=" + ModelName + ", customerName=" + customerName + ", price=" + price + "]";
	}
	public void setColour(String colour) {
		// TODO Auto-generated method stub
		
	}
	public void setfueltype(String fueltype2) {
		// TODO Auto-generated method stub
		
	}
	public void setcarprice(double carprice) {
		// TODO Auto-generated method stub
		
	}
	public void setBill(double carprice) {
		// TODO Auto-generated method stub
		
	}
	public void setcustomerName(String customername2) {
		// TODO Auto-generated method stub
		
	}
	
}