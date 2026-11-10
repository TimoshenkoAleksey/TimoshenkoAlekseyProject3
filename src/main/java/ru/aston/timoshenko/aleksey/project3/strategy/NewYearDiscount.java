package ru.aston.timoshenko.aleksey.project3.strategy;

public class NewYearDiscount implements DiscountStrategy {

    @Override
    public double calculate(double price) {
        return price * 0.75;
    }
}
