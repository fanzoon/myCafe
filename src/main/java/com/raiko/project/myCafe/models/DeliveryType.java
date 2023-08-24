package com.raiko.project.myCafe.models;

import javax.persistence.*;

@Entity
@Table(name = "deliveries_type")
public class DeliveryType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;

    public DeliveryType() {
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
}
