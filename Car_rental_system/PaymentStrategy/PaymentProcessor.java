package PaymentStrategy;

public class PaymentProcessor {
	public boolean processPayment(double amount, PaymentStrategy strategy) {
		strategy.processPayment(amount);
		return true;
	}
}
