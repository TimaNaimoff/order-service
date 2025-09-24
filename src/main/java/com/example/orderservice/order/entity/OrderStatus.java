package com.example.orderservice.order.entity;


public enum OrderStatus {
    CREATED {
        @Override
        public boolean canTransitionTo(OrderStatus target) {
            return target == PAID || target == CANCELLED;
        }
    },
    PAID {
        @Override
        public boolean canTransitionTo(OrderStatus target) {
            return target == SHIPPED || target == CANCELLED;
        }
    },
    SHIPPED {
        @Override
        public boolean canTransitionTo(OrderStatus target) {
            return target == DELIVERED;
        }
    },
    DELIVERED {
        @Override
        public boolean canTransitionTo(OrderStatus target) {
            return false; // финальное состояние
        }
    },
    CANCELLED {
        @Override
        public boolean canTransitionTo(OrderStatus target) {
            return false; // финальное состояние
        }
    };

    public abstract boolean canTransitionTo(OrderStatus target);
}
