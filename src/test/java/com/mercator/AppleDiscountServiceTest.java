package com.mercator;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppleDiscountServiceTest {
    Product apple = new Product("Apple", BigDecimal.valueOf(0.60));

    @Test
    void appliesDiscount() {
        BigDecimal expected = BigDecimal.valueOf(1.20).setScale(2, RoundingMode.HALF_UP);
        BigDecimal actual = new AppleDiscountService().calculateDiscount(apple, apple,apple, apple);
        assertEquals(expected, actual);

    }

    @Test
    void appliesDiscountHandlesOddNumbers() {
        BigDecimal expected = BigDecimal.valueOf(1.20).setScale(2, RoundingMode.HALF_UP);
        BigDecimal actual = new AppleDiscountService().calculateDiscount(apple, apple,apple, apple, apple);
        assertEquals(expected, actual);
    }

    @Test
    void appliesDiscountHandlesOneProduct() {
        BigDecimal expected = BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_UP);
        BigDecimal actual = new AppleDiscountService().calculateDiscount(apple);
        assertEquals(expected, actual);
    }

    @Test
    void appliesDiscountHandlesNoProducts() {
        BigDecimal expected = BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_UP);
        BigDecimal actual = new AppleDiscountService().calculateDiscount();
        assertEquals(expected, actual);
    }
}
