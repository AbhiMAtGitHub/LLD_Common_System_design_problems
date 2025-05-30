import java.util.*;

import CommonEnums.VehicleType;
import MainRentalSystem.RentalSystem;
import PaymentStrategy.CashPayment;
import PaymentStrategy.CreditCardPayment;
import PaymentStrategy.PaymentStrategy;
import PaymentStrategy.PaypalPayment;
import UtilityClasses.Location;
import UtilityClasses.RentalStore;
import UtilityClasses.Reservation;
import UtilityClasses.User;
import VehicleFactory.Vehicle;
import VehicleFactory.VehicleFactory;

public class Main {
	public static void main(String[] args) {
		RentalSystem rentalSystem = RentalSystem.getInstance();

		// Creating Rental Stores
		RentalStore store1 = new RentalStore(1, "Downtown Rentals", new Location("123 Main st", "New York", "NY", "10001"));
		RentalStore store2 = new RentalStore(2, "Airport Rentals", new Location("456 Airport rd", "Los Angeles", "CA", "90045"));
		
		rentalSystem.addStore(store1);
		rentalSystem.addStore(store2);
		
		Vehicle economyCar = VehicleFactory.createVehicle(VehicleType.ECONOMY, "EC001", "Toyota", 50.0);
		Vehicle luxuryCar = VehicleFactory.createVehicle(VehicleType.LUXURY, "LX001", "Mercedes", 200.0);
		Vehicle suvCar = VehicleFactory.createVehicle(VehicleType.SUV, "SV001", "Honda",  75.0);
		
		store1.addVehicle(economyCar);
		store1.addVehicle(luxuryCar);
		store2.addVehicle(suvCar);
		
		User user1 = new User(123, "ABC", "abc@gmail.com");
		User user2 = new User(456, "DEF", "def@gmail.com");
		
		rentalSystem.registerUser(user1);
		rentalSystem.registerUser(user2);
		
		Reservation reservation1 = rentalSystem.createReservation(user1.getId(), economyCar.getRegistrationNumber(),
				store1.getId(), store1.getId(), new Date(2025 - 1900, 4, 1), new Date(2025 - 1900, 5, 15));
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Processing payment for reservation #" + reservation1.getId());
	    System.out.println("Total amount: $" + reservation1.getTotalAmount());
	    System.out.println("Select payment method:");
	    System.out.println("1. Credit Card");
	    System.out.println("2. Cash");
	    System.out.println("3. PayPal");
	    
	    int choice = 1;
	    PaymentStrategy paymentStrategy;
	    if(choice == 1) {
	    	 paymentStrategy = new CreditCardPayment();
	    } else if(choice == 2) {
	    	paymentStrategy = new CashPayment();
	    } else if(choice == 3) {
	    	paymentStrategy = new PaypalPayment();
	    } else {
	    	System.out.println("Invalid choice! Defaulting to credit card payment.");
	        paymentStrategy = new CreditCardPayment();
	    }
	    
	    boolean paymentSuccess = rentalSystem.processPayment(reservation1.getId(), paymentStrategy);
	    if(paymentSuccess) {
	    	System.out.println("Payment successful!");

            // Start the rental
            rentalSystem.startRental(reservation1.getId());

            // Simulate rental period
            System.out.println("Simulating rental period...");

            // Complete the rental
            rentalSystem.completeRental(reservation1.getId());
	    } else {
	    	System.out.println("Payment failed!");
	    }
	}
}
    
    
	

