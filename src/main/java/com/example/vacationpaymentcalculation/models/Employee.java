package com.example.vacationpaymentcalculation.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Employee {

    Vacation vacation;

    private Double salary;

    public Employee(Vacation vacation, Double salary) {
        try{
            if (salary < 0.0){
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){

            System.exit(0);
        }

        this.vacation = vacation;
        this.salary = salary;
    }
}
