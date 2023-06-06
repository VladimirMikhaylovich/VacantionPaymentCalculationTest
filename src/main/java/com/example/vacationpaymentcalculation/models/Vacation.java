package com.example.vacationpaymentcalculation.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Vacation {


    private LocalDate startDate;
    private LocalDate endDate;
    private ArrayList<LocalDate> vacationDaysList = new ArrayList<>();


   public void makeVacation(){
       if (startDate.isBefore(LocalDate.now()))
           throw new IllegalArgumentException("The date is before then today");

       while (!startDate.isAfter(endDate)){
           vacationDaysList.add(startDate);
           startDate= startDate.plusDays(1);
       }
   }
}
