package com.raiko.project.myCafe.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private DeliveryType deliveriesType;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private PaymentType paymentType;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private OrderStatus orderStatus;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order", orphanRemoval = true)
    private List<OrderDish> orderDishList = new ArrayList<>();


    public Order() {
    }

    public Order(Long id, User user, DeliveryType deliveriesType, PaymentType paymentType, OrderStatus orderStatus, List<OrderDish> orderDishList) {
        this.id = id;
        this.user = user;
        this.deliveriesType = deliveriesType;
        this.paymentType = paymentType;
        this.orderStatus = orderStatus;
        this.orderDishList = orderDishList;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }


    public DeliveryType getDeliveriesType() {
        return deliveriesType;
    }

    public void setDeliveriesType(DeliveryType deliveriesType) {
        this.deliveriesType = deliveriesType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderDish> getOrderDishList() {
        return orderDishList;
    }

    public void setOrderDishList(List<OrderDish> orderDishList) {
        this.orderDishList = orderDishList;
    }
}
