package UtilityClasses;

import java.util.*;

public class User {
	private int id;
	private String name;
	private String email;
	private List<Reservation> reservations;
	
	public User(int id, String name, String email) {
        this.setId(id);
        this.setName(name);
        this.setEmail(email);
        this.reservations = new ArrayList<>();
    }
	
	 public void addReservation(Reservation reservation) {
		 reservations.add(reservation);
	 }

	 public void deleteReservation(Reservation reservation) {
		 reservations.remove(reservation);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
