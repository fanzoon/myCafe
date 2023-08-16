package com.raiko.project.myCafe.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dishes")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "weight", nullable = false)
    private Integer weight;

    @Column(name = "price")
    private Double price;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dish", orphanRemoval = true)
    private List<OrderDish> orderDishList = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private DishCategory dishCategory;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dish")
    private List<Image> images = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dish")
    private List<Review> reviews = new ArrayList<>();

    public Dish() {

    }

    public Dish(Long id,
                String name,
                String description,
                Integer weight,
                Double price,
                List<OrderDish> orderDishList,
                DishCategory dishCategory,
                List<Image> images,
                List<Review> reviews) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.price = price;
        this.orderDishList = orderDishList;
        this.dishCategory = dishCategory;
        this.images = images;
        this.reviews = reviews;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderDish> getOrderDishList() {
        return orderDishList;
    }

    public void setOrderDishList(List<OrderDish> orderDishList) {
        this.orderDishList = orderDishList;
    }

    public DishCategory getDishCategory() {
        return dishCategory;
    }

    public void setDishCategory(DishCategory dishCategory) {
        this.dishCategory = dishCategory;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
