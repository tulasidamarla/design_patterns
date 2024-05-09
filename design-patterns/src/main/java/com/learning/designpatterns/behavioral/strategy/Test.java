package com.learning.designpatterns.behavioral.strategy;

import com.learning.designpatterns.behavioral.strategy.strategy.PaymentByCreditCard;
import com.learning.designpatterns.behavioral.strategy.strategy.PaymentByPayPal;

public class Test {
    public static void main(String[] args) {

        PaymentService paymentService = new PaymentService();
        // The strategy can now be easily picked at runtime

        paymentService.setStrategy(new PaymentByCreditCard());
        paymentService.processOrder(100);

        System.out.println("==========================================");

        paymentService.setStrategy(new PaymentByPayPal());
        paymentService.processOrder(100);

    }
}
