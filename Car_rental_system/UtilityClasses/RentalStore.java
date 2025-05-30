package UtilityClasses;

import java.util.*;

import CommonEnums.VehicleStatus;
import VehicleFactory.Vehicle;

public class RentalStore {
	private int id;
	private String name;
	private Location location;
	private Map<String, Vehicle> vehicles; // RegistrationNumber --> Vehicle
	
	public RentalStore(int id, String name, Location location) {
		this.setId(id);
		this.setName(name);
		this.setLocation(location);
		this.vehicles = new HashMap<>();
	}
	
	public List<Vehicle> getAvailableVehicles() {
		List<Vehicle> availableVehicles = new ArrayList<>();
		for(Vehicle vehicle: vehicles.values()) {
			if(vehicle.getStatus() == VehicleStatus.AVAILABLE) {
				availableVehicles.add(vehicle);
			}
		}
		return availableVehicles;
	}
 	
	public void addVehicle(Vehicle vehicle) {
		vehicles.put(vehicle.getRegistrationNumber(), vehicle);
	}
	
	public void removeVehicle(Vehicle vehicle) {
		vehicles.remove(vehicle.getRegistrationNumber());
	}
	
	public Vehicle getVehicle(String registrationNumber) {
        return vehicles.get(registrationNumber);
    }
	
	public boolean isVehicleAvailable(String registrationNumber) {
		Vehicle vehicle = vehicles.get(registrationNumber);
		if(vehicle != null && vehicle.getStatus() == VehicleStatus.AVAILABLE) {
			return true;
		}
		return false;
	}
	
	public Map<String, Vehicle> getAllVehicles() {
		return vehicles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
