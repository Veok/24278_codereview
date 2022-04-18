package model;

import java.util.ArrayList;
import java.util.Date;

public class Invoice {

    private Buyer buyer;
    private Seller seller;
    private String invoicingDate;
    private String paymentDate;
    private InvoicePosition invoicePosition;

    public Invoice(Buyer buyer, Seller seller, String invoicingDate, String paymentDate, InvoicePosition invoicePosition) {
        this.buyer = buyer;
        this.seller = seller;
        this.invoicingDate = invoicingDate;
        this.paymentDate = paymentDate;
        this.invoicePosition = invoicePosition;
    }

    public Invoice() {
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public String getInvoicingDate() {
        return invoicingDate;
    }

    public void setInvoicingDate(String invoicingDate) {
        this.invoicingDate = invoicingDate;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public InvoicePosition getInvoicePosition() {
        return invoicePosition;
    }

    public void setInvoicePosition(InvoicePosition invoicePosition) {
        this.invoicePosition = invoicePosition;
    }

    private ArrayList<InvoicePosition> positions = new ArrayList<InvoicePosition>();

    public ArrayList<InvoicePosition> getPositions() {
        return positions;
    }

    public void setPositions(ArrayList<InvoicePosition> positions) {
        this.positions = positions;
    }

    public void addPosition(InvoicePosition position){
        positions.add(position);
    }

    private InvoicePosition positionWithProduct(Product product){
        for(InvoicePosition position: positions){
            if(position.getProduct().getCode().equals(product.getCode()))
                return position;
        }
        return null;
    }

    public void addPosition(Product product){
        InvoicePosition position = positionWithProduct(product);
        if(position == null){
            addPosition(new InvoicePosition(product));
            return;
        }
        position.setCount(position.getCount()+1);
    }
}
