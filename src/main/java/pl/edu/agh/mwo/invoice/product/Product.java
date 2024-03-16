package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class Product {
    private final String name;

    private final BigDecimal price;

    private final BigDecimal taxPercent;


    protected Product(String name, BigDecimal price, BigDecimal tax) {

        if (name == null) {
            throw new IllegalArgumentException("nazwa nie może być nullem");
        } else if (name.isEmpty()) {

            throw new IllegalArgumentException("nazwa nie może być pusta");
        } else if (price == null) {
            throw new IllegalArgumentException("cena nie może byc nullem");
        } else if (price.doubleValue() < 0.0) {
            throw new IllegalArgumentException("cena nie może być ujemna");
        } else {

            this.name = name;
            this.price = price;
            this.taxPercent = tax;
        }
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public BigDecimal getTaxPercent() {
        return this.taxPercent;
    }

    public BigDecimal getPriceWithTax() {
        BigDecimal priceWithTax = this.price.multiply(this.taxPercent).add(this.price);
        return priceWithTax;
    }
}
