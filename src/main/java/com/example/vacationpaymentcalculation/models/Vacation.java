package com.example.vacationpaymentcalculation.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Vacation {

    private LocalDate startDate;
    private LocalDate endDate;

    Holidays holidays;


    public Vacation(LocalDate startDate, LocalDate endDate) {
        if (startDate.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("The date is before then today");
        this.startDate = startDate;
        this.endDate = endDate.plusDays(1); // to include last day of vacation into period

    }
}
