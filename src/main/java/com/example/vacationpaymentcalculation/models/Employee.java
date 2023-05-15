package com.example.vacationpaymentcalculation.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@Component
public class Employee {

    Vacation vacation;

    private BigDecimal salary;

    public Employee(Vacation vacation, BigDecimal salary) {
        try {
            if (salary.equals(0)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {

            System.exit(0);
        }

        this.vacation = vacation;
        this.salary = salary;
    }
}
