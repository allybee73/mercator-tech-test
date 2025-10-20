package com.mercator;

import java.math.BigDecimal;

public interface DiscountService {

    public BigDecimal calculateDiscount(Product... products);
}
