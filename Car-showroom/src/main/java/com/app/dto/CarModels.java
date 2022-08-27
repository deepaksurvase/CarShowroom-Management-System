package com.app.dto;

import jakarta.persistence.Entity;

@Entity
public class CarModels{
	private int carId;
	private String carName;
	private String fueltype;
	private double carprice;
	private String colour;

	

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

	public String getFueltype() {
		return fueltype;
	}

	public void setFueltype(String fueltype) {
		this.fueltype = fueltype;
	}

	public double getCarprice() {
		return carprice;
	}

	public void setCarprice(double carprice) {
		this.carprice = carprice;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public CarModels(int carId, String carName, String fueltype, double carprice, String colour) {
		super();
		this.carId = carId;
		this.carName = carName;
		this.fueltype = fueltype;
		this.carprice = carprice;
		this.colour = colour;
	}

	@Override
	public String toString() {
		return "CarModels [carId=" + carId + ", carName=" + carName + ", fueltype=" + fueltype + ", carprice="
				+ carprice + ", colour=" + colour + "]";
	}

	
}

