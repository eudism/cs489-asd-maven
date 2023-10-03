package lab1a.productmgmtapp.model;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class ProductMgmtApp {
    public static void main(String[] args) {
        Product[] products = {
                new Product(3128874119l, "Banana", getDate("2023-01-24"), 124, 0.55),
                new Product(2927458265l, "Apple", getDate("2022-12-09"), 18, 1.09),
                new Product(9189927460l, "Carrot", getDate("2023-03-31"), 89, 2.99)
        };

        // Sort products by name in ascending order
        Arrays.sort(products, Comparator.comparing(Product::getName));

        System.out.println("Printed in Comma-seperated value(CSV) format");
        System.out.println("Product Id | Name | Date Supplied | Quantity In Stock | Unit Price (in US$)");
        for (Product product : products) {
            System.out.println(product.toCSVString());
        }
    }

    private static Date getDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
