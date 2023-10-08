package Manager;

import Payment.CreditCardPayment;

import java.util.Scanner;

public class PaymentManager {
    private static PaymentManager instance;
    private PaymentStrategy paymentStrategy;

    private PaymentManager() {
        paymentStrategy = new CreditCardPayment();
    }

    public static PaymentManager getInstance() {
        if (instance == null) {
            instance = new PaymentManager();
        }
        return instance;
    }

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void processPayment(double amount) {
        paymentStrategy.pay(amount);
    }

    public int needToPay() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type the amount you need to pay: ");
        return scanner.nextInt();
    }
}
