package com.raiko.project.myCafe.dtos;

public class BasketDTO {
    private Long dishId;
    private String name;
    private String description;
    private int weight;
    private Double price;
    private int count;
    private Double amount;

    public BasketDTO() {
    }

    public BasketDTO(Long dishId,
                     String name,
                     String description,
                     int weight,
                     Double price,
                     int count,
                     Double amount) {
        this.dishId = dishId;
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.price = price;
        this.count = count;
        this.amount = amount;
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
