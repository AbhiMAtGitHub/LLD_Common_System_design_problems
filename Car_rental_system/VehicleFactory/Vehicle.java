package VehicleFactory;

import CommonEnums.VehicleStatus;
import CommonEnums.VehicleType;

public abstract class Vehicle {
	private String registrationNumber;
	private String model;
	private VehicleType type;
	private VehicleStatus status;
	private double baseRentalPrice;
	
	public Vehicle(String registrationNumber, String model, VehicleType type, double baseRentalPrice) {
		this.registrationNumber = registrationNumber;
        this.model = model;
        this.type = type;
        this.status = VehicleStatus.AVAILABLE;
        this.setBaseRentalPrice(baseRentalPrice);
	}
	
	public abstract double calculateRentalFee(int days);
	
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public VehicleType getType() {
		return type;
	}
	public void setType(VehicleType type) {
		this.type = type;
	}
	public VehicleStatus getStatus() {
		return status;
	}
	public void setStatus(VehicleStatus status) {
		this.status = status;
	}

	public double getBaseRentalPrice() {
		return baseRentalPrice;
	}

	public void setBaseRentalPrice(double baseRentalPrice) {
		this.baseRentalPrice = baseRentalPrice;
	}
}
