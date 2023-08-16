package com.raiko.project.myCafe.models;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "message")
    private String message;

    @Column(name = "mark")
    private Integer mark;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Dish dish;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private User user;

    public Review() {
    }

    public Review(Long id, String message, Integer mark, Dish dish, User user) {
        this.id = id;
        this.message = message;
        this.mark = mark;
        this.dish = dish;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
