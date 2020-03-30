package com.aor.refactoring.example3;

public class Discount {
    private final int fixed;
    private final double percentage;

    public Discount(int fixed) {
        this.fixed = fixed;
        this.percentage = 0;
    }

    public Discount(double percentage) {
        this.percentage = percentage;
        this.fixed = 0;
    }

    public double applyDiscount(double price) {
        if (fixed > 0) return (fixed > price) ? 0 : price - fixed;
        if (percentage > 0) return price - price * percentage;
        return price;
    }
}
