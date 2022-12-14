package me.whiteship.refactoring._06_mutable_data._22_combine_functions_into_transform._02_after;

import java.time.Month;
import java.time.Year;

public class ReadingClient {

    protected double taxThreshold(Year year) {
        return 5;
    }

    protected double baseRate(Month month, Year year) {
        return 10;
    }


    /**
     * EnrichReading 이라는 record 자료 구조를 만들고 메서드를 통해서 접근가능하게 하는 것임
     * @param reading
     * @return
     */
    protected EnrichReading enrichReading(Reading reading) {
        return new EnrichReading(reading, baseCharge(reading), taxableCharge(reading));
    }

    private double taxableCharge(Reading reading) {
        return Math.max(0, baseCharge(reading) - taxThreshold(reading.year()));
    }

    private double baseCharge(Reading reading) {
        return baseRate(reading.month(), reading.year()) * reading.quantity();
    }

}
