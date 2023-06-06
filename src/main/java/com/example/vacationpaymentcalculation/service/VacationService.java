package com.example.vacationpaymentcalculation.service;

import com.example.vacationpaymentcalculation.models.Vacation;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface VacationService {

    BigDecimal getVacationPayment(BigDecimal salary, LocalDate startDate, LocalDate endDate);

    int countHolidays(Vacation vacation);
}
