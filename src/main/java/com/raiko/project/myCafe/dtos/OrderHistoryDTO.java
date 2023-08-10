package com.raiko.project.myCafe.dtos;

import java.time.LocalDate;

public class OrderHistoryDTO {
    private Integer number;
    private String deliveriesType;
    private String paymentType;
    private Double amount;
    private LocalDate dateOfOrdering;

    public OrderHistoryDTO() {
    }

    public OrderHistoryDTO(Integer number, String deliveriesType, String paymentType, Double amount, LocalDate dateOfOrdering) {
        this.number = number;
        this.deliveriesType = deliveriesType;
        this.paymentType = paymentType;
        this.amount = amount;
        this.dateOfOrdering = dateOfOrdering;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDeliveriesType() {
        return deliveriesType;
    }

    public void setDeliveriesType(String deliveriesType) {
        this.deliveriesType = deliveriesType;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDateOfOrdering() {
        return dateOfOrdering;
    }

    public void setDateOfOrdering(LocalDate dateOfOrdering) {
        this.dateOfOrdering = dateOfOrdering;
    }
}
