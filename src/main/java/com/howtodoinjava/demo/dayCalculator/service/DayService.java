package com.howtodoinjava.demo.dayCalculator.service;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;

@Service
public class DayService {

    public Integer d;
    public Integer calculateDays(String startDate, String endDate) {

        LocalDate localDate = LocalDate.parse(startDate);
        LocalDate localDate2 = LocalDate.parse(endDate);
        Period p = Period.between(localDate, localDate2);
        d= p.getDays();
        return p.getDays();

    }

}
