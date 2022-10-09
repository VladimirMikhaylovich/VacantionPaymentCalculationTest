package com.example.vacationpaymentcalculation.service;

import com.example.vacationpaymentcalculation.models.Employee;
import com.example.vacationpaymentcalculation.models.Holidays;
import com.example.vacationpaymentcalculation.models.Vacation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;


@Service
public class VacationServiceImplementation implements VacationService {
    Holidays holidays = new Holidays();

    @Override
    public Double getVacationPayment(Double salary, LocalDate startDate, LocalDate endDate) {
        Vacation vacation = new Vacation(startDate, endDate);
        Employee employee = new Employee(vacation, salary);

        Double vacationPayment = salary / 29.3 * checkWeekEndsDay(vacation);

//            String message = "Salary for your vacation is " + String.format("%.2f", vacationPayment);
        vacationPayment = Math.round(vacationPayment*10.0)/10.0;
        return vacationPayment;
//            return "No vacation more";
    }


    @Override
    public int checkWeekEndsDay(Vacation vacation) {
        Period vacationPeriod = Period.between(vacation.getStartDate(), vacation.getEndDate());
        ArrayList<LocalDate> holidayList = holidays.makeHolidayList();
        int days = vacationPeriod.getDays();
        for(LocalDate date = vacation.getStartDate(); date.isBefore(vacation.getEndDate());date=date.plusDays(1)){
            if(date.getDayOfWeek().equals(DayOfWeek.SATURDAY) || date.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
                days++;}
            else{
                for(LocalDate date2: holidayList){
                    if(date.equals(date2))
                        days++;
                }
            }
        }
        return days;
    }

}
