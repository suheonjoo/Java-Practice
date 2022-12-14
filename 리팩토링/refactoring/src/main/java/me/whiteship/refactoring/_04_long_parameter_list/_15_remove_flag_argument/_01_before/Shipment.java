package me.whiteship.refactoring._04_long_parameter_list._15_remove_flag_argument._01_before;

import java.time.LocalDate;

public class Shipment {

    public LocalDate deliveryDate(Order order, boolean isRush) {
        /**
         * “조건문 분해하기 (Decompose Condition)”
         * 그리고 이거에 따른 테스트 코드도 수정함
         */
        int deliveryTime;
        if (isRush) {
            deliveryTime = switch (order.getDeliveryState()) {
                case "WA", "CA", "OR" -> 1;
                case "TX", "NY", "FL" -> 2;
                default -> 3;
            };
        } else {
            deliveryTime = switch (order.getDeliveryState()) {
                case "WA", "CA" -> 2;
                case "OR", "TX", "NY" -> 3;
                default -> 4;
            };
        }
        return order.getPlacedOn().plusDays(deliveryTime);
    }

}
