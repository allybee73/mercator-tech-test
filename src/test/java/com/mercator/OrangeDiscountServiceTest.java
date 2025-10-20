package com.mercator;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class OrangeDiscountServiceTest {
    Product apple = new Product("Apple", BigDecimal.valueOf(0.60));
    Product orange = new Product("Orange", BigDecimal.valueOf(0.25));

    @Test
    void appliesDiscount() {
        BigDecimal expected = BigDecimal.valueOf(0.25).setScale(2, RoundingMode.HALF_UP);
        BigDecimal actual = new OrangeDiscountService().calculateDiscount(orange, orange,orange, orange);
        assertEquals(expected, actual);
    }

    @Test
    void appliesDiscountIgnoresApples() {
        BigDecimal expected = BigDecimal.valueOf(0.25).setScale(2, RoundingMode.HALF_UP);
        BigDecimal actual = new OrangeDiscountService().calculateDiscount(orange, orange,orange, orange ,apple);
        assertEquals(expected, actual);
    }
    @Test
    void appliesDiscountHandlesOddNumbers() {
        BigDecimal expected = BigDecimal.valueOf(0.25).setScale(2, RoundingMode.HALF_UP);
        BigDecimal actual = new OrangeDiscountService().calculateDiscount(orange, orange,orange, orange ,orange);
        assertEquals(expected, actual);
    }
    @Test
    void appliesDiscountHandlesOneProduct() {
        BigDecimal expected = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        BigDecimal actual = new OrangeDiscountService().calculateDiscount(orange);
        assertEquals(expected, actual);
    }

    @Test
    void appliesDiscountHandlesNoProducts() {
        BigDecimal expected = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        BigDecimal actual = new OrangeDiscountService().calculateDiscount();
        assertEquals(expected, actual);
    }
}