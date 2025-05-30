package UtilityClasses;

import java.util.Date;

import CommonEnums.ReservationStatus;
import CommonEnums.VehicleStatus;
import VehicleFactory.Vehicle;

public class Reservation {
	private int id;
	private User user;
	private Vehicle vehicle;
	private RentalStore pickupStore;
	private RentalStore returnStore;
	private Date startDate;
	private Date endDate;
	private ReservationStatus status;
	private double totalAmount;
	
	
	public Reservation(int id, User user, Vehicle vehicle, RentalStore pickupStore, RentalStore returnStore, Date startDate, Date endDate) {
		this.setId(id);
		this.user = user;
		this.vehicle = vehicle;
		this.pickupStore = pickupStore;
		this.returnStore = returnStore;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = ReservationStatus.PENDING;
		
		// Calculate days between start and end dates
		long diffInMillies = endDate.getTime() - startDate.getTime();
        int days = (int) (diffInMillies / (1000 * 60 * 60 * 24)) + 1;
        this.setTotalAmount(vehicle.calculateRentalFee(days));
	}
	
	public void confirmReservation() {
		if(status == ReservationStatus.PENDING) {
			status = ReservationStatus.CONFIRMED;
			vehicle.setStatus(VehicleStatus.RESERVED);
		}
	}
	
	public void cancelReservation() {
		if(status == ReservationStatus.PENDING || status == ReservationStatus.CONFIRMED) {
			status = ReservationStatus.CANCELED;
			vehicle.setStatus(VehicleStatus.AVAILABLE);
		}
	}
	
	public void startRental() {
		if(status == ReservationStatus.CONFIRMED) {
			status = ReservationStatus.IN_PROGRESS;
			vehicle.setStatus(VehicleStatus.RENTED);
		}
	}
	
	public void completeRental() {
		if(status == ReservationStatus.IN_PROGRESS) {
			status = ReservationStatus.COMPLETED;
			vehicle.setStatus(VehicleStatus.AVAILABLE);
		}
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
