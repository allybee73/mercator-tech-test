package com.mercator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

public class OrangeDiscountService implements DiscountService {
    private String qualifyingProductName = "orange";
    private BigDecimal qualifyingProductPrice = BigDecimal.valueOf(0.25);

    @Override
    public BigDecimal calculateDiscount(Product... products) {
        List<Product> productList = Arrays.stream(products)
                .filter(p -> p.name().toLowerCase().equals(qualifyingProductName))
                .toList();


        int freeItems = productList.size() / 3;
        BigDecimal amountOff = BigDecimal.valueOf(freeItems).multiply(qualifyingProductPrice);

        return amountOff.setScale(2, RoundingMode.HALF_UP);
    }
}
