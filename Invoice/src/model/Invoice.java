package model;

import java.util.Date;

public class Invoice {

    public String buyer;
    public String seller;
    public Date invoicingDate;
    public Date paymentDate;

    public Invoice(String buyer, String seller, Date invoicingDate, Date paymentDate) {
        this.buyer = buyer;
        this.seller = seller;
        this.invoicingDate = invoicingDate;
        this.paymentDate = paymentDate;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Date getInvoicingDate() {
        return invoicingDate;
    }

    public void setInvoicingDate(Date invoicingDate) {
        this.invoicingDate = invoicingDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
