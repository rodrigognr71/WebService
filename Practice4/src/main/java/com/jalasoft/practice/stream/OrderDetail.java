package com.jalasoft.practice.stream;

import java.util.List;

public class OrderDetail {
    private String detailCode;
    private String product;
    private int quantity;
    private int price;
    private int discount;
    private int total;
    private String orders;

    public OrderDetail(String detailCode, String product, int quantity, int price,
                       int discount, int total, String orders) {
        this.detailCode = detailCode;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
        this.total = total;
        this.orders = orders;
    }

    public String getDetailCode() {
        return detailCode;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscount() {
        return discount;
    }

    public int getTotal() {
        return total;
    }

    public String getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return this.orders;
    }
}
