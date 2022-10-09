package com.example.vacationpaymentcalculation.service;

import com.example.vacationpaymentcalculation.models.Vacation;

import java.time.LocalDate;

public interface VacationService {

    Double getVacationPayment(Double salary, LocalDate startDate, LocalDate endDate);

    int checkWeekEndsDay(Vacation vacation);
}
