import Manager.PaymentManager;
import Manager.PaymentStrategy;
import Payment.BitcoinPayment;
import Payment.PayPalPayment;
import Payment.PaymentDecorator;

public class Main {
    public static void main(String[] args) {
        PaymentManager paymentManager = PaymentManager.getInstance();
        int cash = paymentManager.needToPay();

        paymentManager.processPayment(cash);

        paymentManager.setPaymentStrategy(new PayPalPayment());
        paymentManager.processPayment(cash);

        paymentManager.setPaymentStrategy(new BitcoinPayment());
        paymentManager.processPayment(cash);


        PaymentStrategy bitcoinWithDiscount = new PaymentDecorator(new BitcoinPayment(), 0.1);

        paymentManager.setPaymentStrategy(bitcoinWithDiscount);
        paymentManager.processPayment(cash);
    }
}
