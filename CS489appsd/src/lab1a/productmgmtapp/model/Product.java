package lab1a.productmgmtapp.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
    private long productId;
    private String name;
    private Date dateSupplied;
    private int quantityInStock;
    private double unitPrice;

    public Product() {

    }

    public Product(long productId, String name, Date dateSupplied, int quantityInStock, double unitPrice) {
        this.productId = productId;
        this.name = name;
        this.dateSupplied = dateSupplied;
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateSupplied() {
        return dateSupplied;
    }

    public void setDateSupplied(Date dateSupplied) {
        this.dateSupplied = dateSupplied;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    private String formatDate(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
    public String toCSVString() {
        return productId + ", " + name + ", " + formatDate(dateSupplied) + ", " +
                quantityInStock + ", " + unitPrice;
    }
}
