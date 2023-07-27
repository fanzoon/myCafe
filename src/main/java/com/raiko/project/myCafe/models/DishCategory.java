package com.raiko.project.myCafe.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dishes_categories")
public class DishCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;
    @Column(name = "name")
    private String name;
    @Column(name = "number_priority")
    private Integer numberPriority;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dishCategory")
    private List<Dish> dish = new ArrayList<>();

    public DishCategory() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberPriority() {
        return numberPriority;
    }

    public void setNumberPriority(Integer numberPriority) {
        this.numberPriority = numberPriority;
    }

    public List<Dish> getDish() {
        return dish;
    }

    public void setDish(List<Dish> dish) {
        this.dish = dish;
    }
}
