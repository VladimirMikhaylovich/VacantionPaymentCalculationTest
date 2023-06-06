package com.example.vacationpaymentcalculation.service;

import com.example.vacationpaymentcalculation.models.Holidays;
import com.example.vacationpaymentcalculation.models.Vacation;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


@Service
public class VacationServiceImplementation implements VacationService {
    private final Holidays holidays;
    private final Vacation vacation;

    public VacationServiceImplementation(Holidays holidays, Vacation vacation) {
        this.holidays = holidays;
        this.vacation = vacation;
    }

    @Override
    public BigDecimal getVacationPayment(BigDecimal salary, LocalDate startDate, LocalDate endDate) {
        vacation.setStartDate(startDate);
        vacation.setEndDate(endDate);
        vacation.makeVacation();
        ArrayList<LocalDate> vacationDuration = vacation.getVacationDaysList();
        int days = vacationDuration.size();

        BigDecimal vacationPayment = BigDecimal.valueOf(salary.doubleValue() / 29.3 * (days + countHolidays(vacation)));
        vacationPayment = BigDecimal.valueOf(Math.round(vacationPayment.doubleValue() * 10.0) / 10.0);
        return vacationPayment;
    }



    @Override
    public int countHolidays(Vacation vacation) {
        int days = 0;
        vacation.makeVacation();
        ArrayList<LocalDate> vacationDaysList = vacation.getVacationDaysList();
        ArrayList<LocalDate> holidaysList = holidays.makeHolidayList();
        vacationDaysList.retainAll(holidaysList);
        days = vacationDaysList.size();
        return days;
    }

}
