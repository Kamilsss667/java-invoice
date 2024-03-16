package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import pl.edu.agh.mwo.invoice.product.Product;


public class Invoice {
    private Map<Product, Integer> products = new HashMap();

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("The product cannot be null");
        }
    }

    public void addProduct(Product product, Integer quantity) {
        if (product == null || quantity <= 0) {

        throw new IllegalArgumentException("The product cannot be null and the quantity has to be > 0");
    }
        products.put(product, quantity);
    }

    public BigDecimal getNetPrice() {
        BigDecimal netPrice = BigDecimal.ZERO;

        for (Map.Entry<Product, Integer> product : products.entrySet()){
            BigDecimal productPrice = product.getKey().getPrice();
            Integer quantity = product.getValue();
            netPrice = netPrice.add(productPrice.multiply((new BigDecimal(quantity))));
        }
        return netPrice;
    }

    public BigDecimal getTax() {
        BigDecimal totalTax = BigDecimal.ZERO;

        BigDecimal productPrice;
        Integer quantity;
        for(Iterator var3 = this.products.entrySet().iterator(); var3.hasNext(); totalTax = totalTax.add(productPrice.multiply(new BigDecimal(quantity)))) {
            Map.Entry<Product, Integer> product = (Map.Entry)var3.next();
            productPrice = ((Product)product.getKey()).getTaxPercent().multiply(((Product)product.getKey()).getPrice());
            quantity = (Integer)product.getValue();
        }

        return totalTax;
    }

    public BigDecimal getTotal() {
        return null;
    }
}
