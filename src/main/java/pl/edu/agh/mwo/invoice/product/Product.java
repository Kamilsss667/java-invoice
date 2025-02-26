package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class Product {
    private final String name;

    private final BigDecimal price;

    private final BigDecimal taxPercent;


    protected Product(String name, BigDecimal price, BigDecimal tax) {

        if (name == null) {
            throw new IllegalArgumentException("nazwa nie może być nullem");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("nazwa nie może być pusta");
        }
        if (price == null) {
            throw new IllegalArgumentException("cena nie może byc nullem");
        }
        if (price.doubleValue() < 0) {
            throw new IllegalArgumentException("cena nie może być ujemna");
        }

            this.name = name;
            this.price = price;
            this.taxPercent = tax;

    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getTaxPercent() {
        return taxPercent;
    }

    public BigDecimal getPriceWithTax() {
        BigDecimal priceWithTax = price.multiply(taxPercent).add(price);
        return priceWithTax;
    }
}
