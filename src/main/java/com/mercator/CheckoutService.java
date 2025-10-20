package com.mercator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.stream.Stream;

public class CheckoutService {

    public BigDecimal checkout(Product... products) {
        Stream<Product> productStream = Arrays.stream(products);
        BigDecimal amount = productStream.map(
                p -> p.price()
        ).reduce(
                BigDecimal.ZERO, (a, b) -> a.add(b)
        ).setScale(2, RoundingMode.HALF_UP);

        return amount;
    }

}
