package com.aor.refactoring.example1;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderLine> lines;

    public Order() {
        lines = new ArrayList<>();
    }

    public void add(Product product, int quantity) {
        lines.add(new OrderLine(product, quantity));
    }

    public boolean isElegibleForFreeDelivery() {
        if (getTotal() > 100) return true;
        else return false;
    }

    public double getTotal() {
        double total = 0;

        for (OrderLine line : lines)
            total += line.product.getPrice() * line.quantity;
        return total;
    }

    public String printOrder() {
        return printProduct() + printTotal();
    }

    public String printProduct() {
        StringBuffer printBuffer = new StringBuffer();

        for (OrderLine line : lines)
            printBuffer.append(line.product.getName() + "(x" + line.quantity + "): " + (line.product.getPrice() * line.quantity) + "\n");

        return printBuffer.toString();
    }

    public String printTotal() {
        return "Total: " + getTotal();
    }

}