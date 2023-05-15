package com.example.vacationpaymentcalculation;

import com.example.vacationpaymentcalculation.models.Employee;
import com.example.vacationpaymentcalculation.models.Holidays;
import com.example.vacationpaymentcalculation.models.Vacation;
import com.example.vacationpaymentcalculation.service.VacationService;
import com.example.vacationpaymentcalculation.service.VacationServiceImplementation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class VacationPaymentCalculationApplicationTests {

    @Autowired
    VacationService vacationService;


    @Test
    public void creatEmployeeTest(){
        Employee employee = new Employee(null, BigDecimal.valueOf(1));
        assertNotNull(employee);
    }

    @Test
    public void creatVacationTest(){
        LocalDate d1 = LocalDate.of(2023,11,10);
        LocalDate d2 = LocalDate.of(2023,11,17);
        Vacation vacation = new Vacation( d1, d2);
        assertNotNull(vacation);
    }
    @Test
    public void creatHolidaysTest(){
        Holidays holidays = new Holidays();
        assertNotNull(holidays);

    }

    @Test
    public void checkWeekEndsDayTest(){
        LocalDate d1 = LocalDate.of(2023,11,5);
        LocalDate d2 = LocalDate.of(2023,11,11);
        Vacation vacation = new Vacation( d1, d2);
        int days = vacationService.checkWeekEndsDay(vacation);
        assertEquals(9,days);
    }
    @Test
    public void checkWeekEndsDayWithHolidaysTest(){
        LocalDate d1 = LocalDate.of(2023,11,1);
        LocalDate d2 = LocalDate.of(2023,11,4);
        Vacation vacation = new Vacation( d1, d2);
        int days = vacationService.checkWeekEndsDay(vacation);
        assertEquals(5,days);
    }


    @Test
    public void getVacationPaymentTest(){
        BigDecimal value = vacationService.getVacationPayment(
                BigDecimal.valueOf(1000),LocalDate.of(2023,5,15)
                ,LocalDate.of(2023,5,19));
        assertEquals(BigDecimal.valueOf(170.6),value);
    }

}
