package Payment;

import Manager.PaymentStrategy;

public class PaymentDecorator implements PaymentStrategy {
    private PaymentStrategy decoratedPayment;
    private double discount;

    public PaymentDecorator(PaymentStrategy decoratedPayment, double discount) {
        this.decoratedPayment = decoratedPayment;
        this.discount = discount;
    }

    @Override
    public void pay(double amount) {
        double discountedAmount = amount - (amount * discount);
        decoratedPayment.pay(discountedAmount);
    }
}
