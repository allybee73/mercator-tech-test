package com.mercator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

public class AppleDiscountService implements DiscountService {
    private String qualifyingProductName = "apple";
    private BigDecimal qualifyingProductPrice = BigDecimal.valueOf(0.60);

    @Override
    public BigDecimal calculateDiscount(Product... products) {
        List<Product> productList = Arrays.stream(products)
                .filter(p -> p.name().toLowerCase().equals(qualifyingProductName))
                .toList();

        int freeItems = productList.size() / 2;
        
        return qualifyingProductPrice
                .multiply(BigDecimal.valueOf(freeItems))
                .setScale(2, RoundingMode.HALF_UP);
    }
}
