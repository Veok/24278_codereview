package pl.pjait;

import model.*;

import java.awt.desktop.AboutEvent;
import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {

        Product product = new Product("ABC123", "TV", 1000);
        Product fridge = new Product("DEF1345", "Fridge", 5000);
        Buyer buyer = new Buyer("Stefan", "test");
        Seller seller = new Seller("Andrzej", "test");

        InvoicePosition position = new InvoicePosition(product);
        Invoice invoice = new Invoice();
        invoice.setBuyer(buyer);
        invoice.setSeller(seller);
        invoice.setInvoicingDate("02/03/2022");
        invoice.setPaymentDate("02/04/2022");
        invoice.addPosition(position);

        System.out.println("\nStawka VAT: " + InvoicePosition.TAX_5);
        System.out.println("Stawka VAT: " + InvoicePosition.TAX_8);
        System.out.println("Stawka VAT: " + InvoicePosition.TAX_23);

        System.out.println("\nCode: " + product.getCode());
        System.out.println("Name: " + product.getName());
        System.out.println("Price: " + product.getPrice());
        System.out.println("Netto price: " + position.getNettoPrice());
        System.out.println("Brutto price: " + position.getGrossPrice());

        System.out.println("\nCode: " + fridge.getCode());
        System.out.println("Name: " + fridge.getName());
        System.out.println("Price: " + fridge.getPrice());

        invoice.addPosition(new Product("ABC", "salata", 555));
        invoice.addPosition(new Product("NKO", "okon", 14215));
        invoice.addPosition(new Product("SPD", "spodnie", 1415));
        invoice.addPosition(new Product("MLK", "mleko", 11445));
        invoice.addPosition(new Product("WOD", "woda", 6954));

        printoutInvoice(invoice);

    }

    private static void printoutInvoice(Invoice invoice){
        System.out.println("|\t\t\t\t\t\t\tFAKTURA VAT\t\t\t\t\t\t\t|");
        System.out.println("|NAZWA\t|ILOSC\t|CENA NETTO\t|CENA BRUTTO\t|STAWKA VAT\t|PODATEK|");
        System.out.println("*****************************************************************");
        for (InvoicePosition p : invoice.getPositions()){
            System.out.print("|" + p.getProduct().getName() + "\t\t|");
            System.out.print(p.getCount() + "\t\t|");
            System.out.print(p.getNettoPrice() + "\t\t|");
            System.out.print(p.getGrossPrice() + "\t\t\t|");
            System.out.print(p.getTax() + "\t\t|");
            System.out.println(p.getTaxValue() + "\t|");
        }
            System.out.println("-----------------------------------------------------------------");
            System.out.println("|SPRZEDAWCA| " + invoice.getSeller().getName());
            System.out.println("|KUPUJACY| " + invoice.getBuyer().getName());
            System.out.println("|DATA SPRZEDAZY|" + invoice.getInvoicingDate());
            System.out.println("|DATA DO ZAPLATY|" + invoice.getPaymentDate());
            System.out.println("-----------------------------------------------------------------");
    }
}
