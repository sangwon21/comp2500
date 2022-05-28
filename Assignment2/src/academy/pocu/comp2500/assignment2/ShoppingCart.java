package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCart {
    private final List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public void addProductToCart(final Product product, ShippingMethod shippingMethod) {
        product.setShippingMethod(shippingMethod);
        this.products.add(product);
    }

    public boolean removeProductFromCart(final Product product) {
        return this.products.remove(product);
    }

    public int getTotalPrice() {
        int totalSum = 0;

        for (Product product : this.products) {
            totalSum += product.getPrice();
        }

        return totalSum;
    }

    public List<Product> getProducts() {
        return this.products;
    }
}
