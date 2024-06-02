package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public class Alcohols extends Product {
    public Alcohols (String name, BigDecimal price) {
        super(name, price, new BigDecimal("0.23"));
    }

}
