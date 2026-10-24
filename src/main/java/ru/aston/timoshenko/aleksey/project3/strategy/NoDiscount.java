package ru.aston.timoshenko.aleksey.project3.strategy;

public class NoDiscount implements DiscountStrategy {

    @Override
    public double calculate(double price) {
        return price;
    }
}
