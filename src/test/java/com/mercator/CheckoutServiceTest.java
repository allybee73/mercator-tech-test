package com.mercator;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckoutServiceTest {

    Product apple = new Product("Apple", BigDecimal.valueOf(0.60));
    Product orange = new Product("Orange", BigDecimal.valueOf(0.25));

    @Test
    void checkoutCalculatesCorrectPrice() {

        BigDecimal expectedValue = BigDecimal.valueOf(1.45);
        BigDecimal actualValue = new CheckoutService().checkout(apple, apple, orange, apple);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void checkoutHandlesNull() {

        BigDecimal expectedValue = BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_UP);
        BigDecimal actualValue = new CheckoutService().checkout();
        assertEquals(expectedValue, actualValue);
    }



}