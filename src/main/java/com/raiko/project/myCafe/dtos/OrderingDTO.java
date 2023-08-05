package com.raiko.project.myCafe.dtos;

public class OrderingDTO {
    private Long orderId;
    private Long deliveryTypeId;
    private Long paymentTypeId;
    private String deliveryAddress;

    public OrderingDTO() {
    }

    public OrderingDTO(Long orderId, Long deliveryTypeId, Long paymentTypeId, String deliveryAddress) {
        this.orderId = orderId;
        this.deliveryTypeId = deliveryTypeId;
        this.paymentTypeId = paymentTypeId;
        this.deliveryAddress = deliveryAddress;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getDeliveryTypeId() {
        return deliveryTypeId;
    }

    public void setDeliveryTypeId(Long deliveryTypeId) {
        this.deliveryTypeId = deliveryTypeId;
    }

    public Long getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(Long paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}
