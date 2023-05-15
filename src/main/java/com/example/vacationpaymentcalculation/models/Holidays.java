package com.example.vacationpaymentcalculation.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;


@Setter
@Getter
@Component
public class Holidays {

    // private LocalDate nextYear = LocalDate.from(Year.now()).plusYears(1);
    private LocalDate NEW_YEAR;
    private LocalDate MILITARY_DAY;

    private LocalDate WOMEN_DAY;

    private LocalDate VICTORY_DAY;

    private LocalDate LIBERTY_DAY;

    private LocalDate UNITY_DAY;

    private LocalDate[] listOfHolidays = {NEW_YEAR, MILITARY_DAY, WOMEN_DAY, VICTORY_DAY, LIBERTY_DAY, UNITY_DAY};

    public ArrayList<LocalDate> makeHolidayList() {
        ArrayList<LocalDate> list = new ArrayList<>();
        list.add(getNEW_YEAR());
        list.add(getMILITARY_DAY());
        list.add(getWOMEN_DAY());
        list.add(getVICTORY_DAY());
        list.add(getLIBERTY_DAY());
        list.add(getUNITY_DAY());
        return list;
    }

    public Holidays() {
        this.NEW_YEAR = LocalDate.of(Year.now().getValue(), 1, 1).plusYears(1);

        if (LocalDate.of(Year.now().getValue(), 2, 23).isAfter(LocalDate.now())) {
            this.MILITARY_DAY = LocalDate.of(Year.now().getValue(), 2, 23);
        } else {
            this.MILITARY_DAY = LocalDate.of(Year.now().getValue(), 2, 23).plusYears(1);
        }

        if (LocalDate.of(Year.now().getValue(), 3, 8).isAfter(LocalDate.now())) {
            this.WOMEN_DAY = LocalDate.of(Year.now().getValue(), 3, 8);
        } else {
            this.WOMEN_DAY = LocalDate.of(Year.now().getValue(), 3, 8).plusYears(1);
        }

        if (LocalDate.of(Year.now().getValue(), 5, 9).isAfter(LocalDate.now())) {
            this.VICTORY_DAY = LocalDate.of(Year.now().getValue(), 5, 9);
        } else {
            this.VICTORY_DAY = LocalDate.of(Year.now().getValue(), 5, 9).plusYears(1);
        }

        if (LocalDate.of(Year.now().getValue(), 6, 12).isAfter(LocalDate.now())) {
            this.LIBERTY_DAY = LocalDate.of(Year.now().getValue(), 6, 12);
        } else {
            this.LIBERTY_DAY = LocalDate.of(Year.now().getValue(), 6, 12).plusYears(1);
        }

        if ((LocalDate.of(Year.now().getValue(), 11, 4)).isAfter(LocalDate.now())) {
            this.UNITY_DAY = LocalDate.of(Year.now().getValue(), 11, 4);
        } else {
            this.UNITY_DAY = LocalDate.of(Year.now().getValue(), 11, 4).plusYears(1);
        }
    }


}

