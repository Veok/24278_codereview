package pl.pjait;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CartService {

    public Product getCheapestOne(List<Product> products) {
        Product temporaryProduct = new Product();
        temporaryProduct.setPrice(999999);
        for (Product product : products) {
            if (product.getPrice() <= temporaryProduct.getPrice()) {
                temporaryProduct = product;
            }
        }
        return temporaryProduct;
    }

    public List<Product> getCheapestN(List<Product> products, int number) {
        return sortProductsByPrice(products).stream().limit(number).collect(Collectors.toList());
    }

    public Product getExpensiveOne(List<Product> products) {
        Product temporaryProduct = new Product();
        temporaryProduct.setPrice(0);
        for (Product product : products) {
            if (product.getPrice() >= temporaryProduct.getPrice()) {
                temporaryProduct = product;
            }
        }
        return temporaryProduct;
    }

    public List<Product> getExpensiveN(List<Product> products, int number) {
        Collections.reverse(sortProductsByPrice(products));
        return products.stream().limit(number).collect(Collectors.toList());
    }

    public List<Product> sortProductsByName(List<Product> products) {
        return products.stream().sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());
    }

    public List<Product> sortProductsByPrice(List<Product> products) {
        return products.stream().sorted(Comparator.comparing(Product::getPrice))
                .collect(Collectors.toList());
    }

    public double getSumOfCart(Cart cart) {
        double totalPrice = 0;
        for (Product product : cart.getProducts()) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}