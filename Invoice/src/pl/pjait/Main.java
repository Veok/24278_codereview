package pl.pjait;

import model.InvoicePosition;
import model.Product;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {

        Product product = new Product("ABC123", "TV", 1000);

        InvoicePosition position = new InvoicePosition(product);
        position.getNettoPrice();

        System.out.println("Stawka VAT: " + InvoicePosition.TAX_5);
        System.out.println("Stawka VAT: " + InvoicePosition.TAX_8);
        System.out.println("Stawka VAT: " + InvoicePosition.TAX_23);

        System.out.println("Code: " + product.getCode());
        System.out.println("Name: " + product.getName());
        System.out.println("Price: " + product.getPrice());

    }
}
