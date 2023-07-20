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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderDish> orderDishList = new ArrayList<>();

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
