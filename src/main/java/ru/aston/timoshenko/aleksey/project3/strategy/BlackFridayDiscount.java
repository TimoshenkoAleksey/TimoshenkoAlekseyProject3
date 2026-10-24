package ru.aston.timoshenko.aleksey.project3.strategy;

public class BlackFridayDiscount implements DiscountStrategy {

    @Override
    public double calculate(double price) {
        return price * 0.2;
    }
}
