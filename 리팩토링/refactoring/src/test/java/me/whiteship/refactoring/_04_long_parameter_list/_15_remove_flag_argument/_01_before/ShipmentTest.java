package me.whiteship.refactoring._04_long_parameter_list._15_remove_flag_argument._01_before;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class ShipmentTest {

    @Test
    void deliveryDate() {
        LocalDate placedOn = LocalDate.of(2021, 12, 15);
        Order orderFromWA = new Order(placedOn, "WA");

        Shipment shipment = new Shipment();
        assertEquals(placedOn.plusDays(1), shipment.deliveryDate(orderFromWA,true));
        assertEquals(placedOn.plusDays(2), shipment.deliveryDate(orderFromWA,false));
    }

}