package com.jalasoft.practice.stream;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args){

        OrderDetail orderDetail1 = new OrderDetail("cod1", "cocina", 2,
                1000, 10, 1990, "ped1");

        OrderDetail orderDetail2 = new OrderDetail("cod2", "lavadora", 1,
                2500, 0, 2500, "ped1");

        OrderDetail orderDetail3 = new OrderDetail("cod3", "plancha", 5,
                300, 50, 1450, "ped1");

        OrderDetail orderDetail4 = new OrderDetail("cod4", "mesa", 2,
                700, 30, 1370, "ped2");

        OrderDetail orderDetail5 = new OrderDetail("cod5", "muebles", 1,
                3500, 0, 3500, "ped2");

        OrderDetail orderDetail6 = new OrderDetail("cod6", "comoda", 3,
                800, 100, 2300, "ped2");

        OrderDetail orderDetail7 = new OrderDetail("cod7", "camisa", 10,
                100, 00, 900, "ped3");

        OrderDetail orderDetail8 = new OrderDetail("cod8", "polera", 20,
                80, 0, 1600, "ped3");

        OrderDetail orderDetail9 = new OrderDetail("cod9", "zapatos", 8,
                400, 200, 3000, "ped3");

        List<OrderDetail> orderDetailList = new ArrayList<>();
        orderDetailList.add(orderDetail1);
        orderDetailList.add(orderDetail2);
        orderDetailList.add(orderDetail3);
        orderDetailList.add(orderDetail4);
        orderDetailList.add(orderDetail5);
        orderDetailList.add(orderDetail6);
        orderDetailList.add(orderDetail7);
        orderDetailList.add(orderDetail8);
        orderDetailList.add(orderDetail9);

        Order order1 = new Order("ped1", "normal", "Juan",
                "Perez","2020-05-05");
        Order order2 = new Order("ped2", "programado", "Maria",
                "Guaman","2020-05-03");
        Order order3 = new Order("ped3", "normal", "Juan",
                "Perez","2020-05-10");

        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);


        // Select cliente from Pedido
        orderList.stream()
                .map(order->order.getClientName() + " " + order.getClientLastName())
                .forEach(value->System.out.println(value));

        System.out.println("-----------------");
        // Select cliente from Pedido where tipoPedido = “normal”
        orderList.stream()
                .filter(order->order.getOrderType().equals("normal") )
                .map(order->order.getClientName() + " " + order.getClientLastName())
                .forEach(value->System.out.println(value));

        System.out.println("-----------------");
        // Select codPedido from Pedido where fecha = “2020-05-05”
        orderList.stream()
                .filter(order->order.getDate().equals("2020-05-05") )
                .map(order->order.getCodOrder())
                .forEach(value->System.out.println(value));

        System.out.println("-----------------");
        // Select producto from Detalle, Pedido where Pedido.codPedido = Detalle.codPedido and
        //Pedido.codPedido = “ped1”
        orderDetailList.stream()
                .filter(orderDetail -> orderDetail.getOrders().equals("ped1"))
                .map(orderDetail -> orderDetail.getProduct())
                .forEach(value->System.out.println(value));

        System.out.println("-----------------");
        // Select Detalle.producto from Detalle, Pedido where Pedido.codPedido = Detalle.codPedido
        //and Detalle.cantidad > 8
        orderDetailList.stream()
                .filter(orderDetail ->  orderDetail.getQuantity() > 8)
                .map(orderDetail -> orderDetail.getProduct())
                .forEach(value->System.out.println(value));










    }
}
