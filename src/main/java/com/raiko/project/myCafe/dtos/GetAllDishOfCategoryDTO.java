package com.raiko.project.myCafe.dtos;

public class GetAllDishOfCategoryDTO {
    private Long id;
    private String name;
    private int weight;
    private String description;
    private Double price;
    private Long imageId;
    private Boolean activity;

    public GetAllDishOfCategoryDTO() {
    }

    public GetAllDishOfCategoryDTO(Long id,
                                   String name,
                                   int weight,
                                   String description,
                                   Double price,
                                   Long imageId,
                                   Boolean activity) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.description = description;
        this.price = price;
        this.imageId = imageId;
        this.activity = activity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Boolean getActivity() {
        return activity;
    }

    public void setActivity(Boolean activity) {
        this.activity = activity;
    }
}
