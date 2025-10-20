package com.mercator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

public class CheckoutService {

    private static final List<DiscountService> currentDiscounts = List.of(new AppleDiscountService(), new OrangeDiscountService());

    public BigDecimal checkout(Product... products) {
        BigDecimal amount = Arrays.stream(products).map(
                p -> p.price()
        ).reduce(
                BigDecimal.ZERO, (a, b) -> a.add(b)
        ).setScale(2, RoundingMode.HALF_UP);

        return applyDiscounts(amount, products);
    }

    private BigDecimal applyDiscounts(BigDecimal currentAmount, Product... products) {
        for (DiscountService discountService : currentDiscounts) {
            currentAmount = currentAmount.subtract(discountService.calculateDiscount(products));
        }

        return currentAmount;
    }

}
