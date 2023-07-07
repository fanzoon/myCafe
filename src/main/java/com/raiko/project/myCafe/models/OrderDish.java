package com.raiko.project.myCafe.models;

import javax.persistence.*;

@Entity
@Table(name = "orders_dishes")
public class OrderDish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private Order order;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private Dish dish;
    @Column(name = "count")
    private int count;
}
