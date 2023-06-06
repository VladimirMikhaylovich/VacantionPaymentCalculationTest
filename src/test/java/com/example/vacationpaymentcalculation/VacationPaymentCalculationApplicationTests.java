package com.example.vacationpaymentcalculation;

import com.example.vacationpaymentcalculation.models.Employee;
import com.example.vacationpaymentcalculation.models.Holidays;
import com.example.vacationpaymentcalculation.models.Vacation;
import com.example.vacationpaymentcalculation.service.VacationService;
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
    @Autowired
    Vacation vacation;

    @Test
    public void checkWeekEndsDayWithHolidaysTest(){
          LocalDate d1 = LocalDate.of(2023,11,1);
        LocalDate d2 = LocalDate.of(2023,11,5);
        vacation.setStartDate(d1);
        vacation.setEndDate(d2);
        int days = vacationService.countHolidays(vacation);
        assertEquals(1,days);
    }


    @Test
    public void getVacationPaymentTest(){
        BigDecimal value = vacationService.getVacationPayment(
                BigDecimal.valueOf(1000),LocalDate.of(2023,11,01)
                ,LocalDate.of(2023,11,05));
        assertEquals(BigDecimal.valueOf(204.8),value);
    }

}
