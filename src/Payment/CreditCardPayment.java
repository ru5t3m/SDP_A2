package Payment;

import Manager.PaymentStrategy;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("It is $" + amount + " to pay via Credit Card.");
    }
}
