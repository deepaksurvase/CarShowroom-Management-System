package com.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OrderInfo
{
	@Id
	@GeneratedValue (strategy =  GenerationType.AUTO)                                            //@GeneratedValue(strategy = GenerationType.AUTO)
	private int carId;
	private String carName;
	private double carprice;
	private String fueltype;
	private String colour;
	
	public OrderInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public double getCarprice() {
		return carprice;
	}
	public void setCarprice(double carprice) {
		this.carprice = carprice;
	}
	public String getFueltype() {
		return fueltype;
	}
	public void setFueltype(String fueltype) {
		this.fueltype = fueltype;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	
	
	public OrderInfo(int carId, String carName, double carprice, String fueltype, String colour) {
		super();
		this.carId = carId;
		this.carName = carName;
		this.carprice = carprice;
		this.fueltype = fueltype;
		this.colour = colour;
		
		
		
	}
	
	@Override
	public String toString() {
		return "OrderInfo [carId=" + carId + ", carName=" + carName + ", carprice=" + carprice + ", fueltype="
				+ fueltype + ", colour=" + colour + "]";
	}
	
}
