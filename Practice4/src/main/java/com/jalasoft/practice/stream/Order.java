package com.jalasoft.practice.stream;

public class Order {
    private String codOrder;
    private String orderType;
    private String clientName;
    private String clientLastName;
    private String date;

    public Order(String codOrder, String orderType, String clientName, String clientLastName, String date) {
        this.codOrder = codOrder;
        this.orderType = orderType;
        this.clientName = clientName;
        this.clientLastName = clientLastName;
        this.date = date;
    }

    public String getCodOrder() {
        return codOrder;
    }

    public String getOrderType() {
        return orderType;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public String getDate() {
        return date;
    }
}
