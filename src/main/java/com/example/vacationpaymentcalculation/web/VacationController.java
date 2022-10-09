package com.example.vacationpaymentcalculation.web;

import com.example.vacationpaymentcalculation.service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/calculacte")
public class VacationController {
    @Autowired
    VacationService vacationService;

    @GetMapping("/{salary}/{startDate}/{endDate}")
    Double getPayment(@PathVariable Double salary,
                      @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                      @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate){
        return vacationService.getVacationPayment(salary, startDate, endDate);
    }
}
