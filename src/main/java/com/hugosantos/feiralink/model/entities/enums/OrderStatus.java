package com.hugosantos.feiralink.model.entities.enums;

import lombok.Getter;

@Getter
public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELLED(5);

    OrderStatus(int code) {
        this.code = code;
    }

    private final int code;

    public static OrderStatus valueOf(int code) {
        for (OrderStatus status : values()) {
            if (status.code == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid order status code: " + code);
    }
}
