package com.raiko.project.myCafe.models;

import javax.persistence.*;

@Entity
@Table(name = "orders_dishes")
public class OrderDish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Order order;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Dish dish;
    @Column(name = "count")
    private int count;

    public OrderDish() {
    }

    public OrderDish(Long id, Order order, Dish dish, int count) {
        this.id = id;
        this.order = order;
        this.dish = dish;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
