package PaymentStrategy;

public class PaypalPayment implements PaymentStrategy{

	@Override
	public void processPayment(double amount) {
		System.out.println("Processing paypal of INR " + amount);
	}
	
}
