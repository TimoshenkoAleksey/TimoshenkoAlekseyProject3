package ru.aston.timoshenko.aleksey.project3.strategy;

import java.util.Map;

public class Cart {
    private static final double DEFAULT_PRICE = 1000;

    private static final Map<Discount, DiscountStrategy> STRATEGY = Map.of(
            Discount.NEW_YEAR, new NewYearDiscount(),
            Discount.BLACK_FRIDAY, new BlackFridayDiscount(),
            Discount.FRENCH, new FrenchDiscount(),
            Discount.NO_DISCOUNT, new NoDiscount()
    );

    public double showPriceWithDiscount(Discount discount) {
        DiscountStrategy discountStrategy = STRATEGY.getOrDefault(discount, STRATEGY.get(Discount.NO_DISCOUNT));
        return discountStrategy.calculate(DEFAULT_PRICE);
    }
}
