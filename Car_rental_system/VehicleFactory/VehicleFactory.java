package VehicleFactory;

import CommonEnums.VehicleType;

public class VehicleFactory {
	public static Vehicle createVehicle(VehicleType type, String registrationNumber, String model, double baseRentalPrice) {
		if(type == VehicleType.ECONOMY) {
			return new EconomyVehicle(registrationNumber, model, type, baseRentalPrice);
		} else if(type == VehicleType.LUXURY) {
			return new LuxuryVehicle(registrationNumber, model, type, baseRentalPrice);
		} else if(type == VehicleType.SUV) {
			return new SUVVehicle(registrationNumber, model, type, baseRentalPrice);
		} else {
			throw new IllegalArgumentException("Unsupported Vehicle Type: " + type);
		}
	}
}
